package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootConfiguration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

  @Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;

  @Autowired
  @Qualifier("JWTHelper")
  private UserDetailsService JWTHelper;


  /**
   * 存储客户端信息
   * @return
   */
  @Bean
  public ClientDetailsService clientDetailsService() {
    InMemoryClientDetailsService inMemoryClientDetailsService = new InMemoryClientDetailsService();
    Map<String, ClientDetails> clients = new HashMap<>(1);
    BaseClientDetails clientDetails = new BaseClientDetails("sanjiaomao", "",
        "all", "password,password,refresh_token", "ROLE_CLIENT","");
    clientDetails.setClientSecret("{bcrypt}$2a$10$StlEgvEQe/r0/kKd9SRqMO2BVocbP.FgHTHVYYMB/UYUcOc4.hWxS");
    clientDetails.setAccessTokenValiditySeconds(60000);
    clientDetails.setRefreshTokenValiditySeconds(1800000);
    clients.put("sanjiaomao", clientDetails);
    inMemoryClientDetailsService.setClientDetailsStore(clients);
    return inMemoryClientDetailsService;
  }


  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(clientDetailsService());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints){
    // 配置token的存储方式为JwtTokenStore
    endpoints.tokenStore(tokenStore())
        // 配置用于JWT私钥加密的增强器
        .tokenEnhancer(jwtTokenEnhancer())
        // 配置安全认证管理
        .authenticationManager(authenticationManager)
        .userDetailsService(JWTHelper);
  }

  /**
   * token存储
   * @return {@link}
   */
  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(jwtTokenEnhancer());
  }

  /**
   * 配置jks文件
   * @return 密钥转换器
   */
  @Bean
  protected JwtAccessTokenConverter jwtTokenEnhancer() {
    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("configuration.jks"), "sanjiaomao".toCharArray());
    JwtAccessTokenConverter converter = new JWTTokenEnhancer();
    converter.setKeyPair(keyStoreKeyFactory.getKeyPair("configuration"));
    return converter;
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
    // 对获取Token的请求不再拦截
    oauthServer.tokenKeyAccess("permitAll()")
        // 验证获取Token的验证信息
        .checkTokenAccess("isAuthenticated()");
  }

}
