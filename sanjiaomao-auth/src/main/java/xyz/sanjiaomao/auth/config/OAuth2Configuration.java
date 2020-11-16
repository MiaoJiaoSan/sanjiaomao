package xyz.sanjiaomao.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

  @Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;





  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
    clients.inMemory()
        .withClient("sanjiaomao")
        .resourceIds("user","auth")
        .authorizedGrantTypes("password", "refresh_token")
        .scopes("all","read", "write")
        .authorities("oauth2")
        .secret(finalSecret)
        .accessTokenValiditySeconds(1200)
        .refreshTokenValiditySeconds(50000)
    ;
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints){
    endpoints.tokenStore(new InMemoryTokenStore())
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
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
