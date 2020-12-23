package xyz.sanjiaomao.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@SpringBootConfiguration
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

  @Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;


  @Autowired
  private DataSource dataSource;

  @Autowired
  private TokenStore tokenStore;


  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(new JdbcClientDetailsService(dataSource));
  }

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }


  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    // 存数据库
    endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);

    // 配置tokenServices参数
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setTokenStore(endpoints.getTokenStore());
    tokenServices.setSupportRefreshToken(true);
    tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
    tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
    tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.SECONDS.toSeconds(10));
    endpoints.tokenServices(tokenServices);
  }


  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
    // 对获取Token的请求不再拦截
    oauthServer.tokenKeyAccess("permitAll()")
        // 验证获取Token的验证信息
        .checkTokenAccess("isAuthenticated()")
        .allowFormAuthenticationForClients();
  }

}
