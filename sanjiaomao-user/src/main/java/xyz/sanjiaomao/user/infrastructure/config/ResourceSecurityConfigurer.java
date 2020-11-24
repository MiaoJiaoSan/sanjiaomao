package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootConfiguration
public class ResourceSecurityConfigurer extends ResourceServerConfigurerAdapter {

  private ResourceServerProperties resource;

  @Resource
  private DataSource dataSource;

  public ResourceSecurityConfigurer(ResourceServerProperties resource) {
    this.resource = resource;
  }


  @Bean
  public JdbcTokenStore jdbcTokenStore(){
    return new JdbcTokenStore(dataSource);
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources)
      throws Exception {
    resources.resourceId(this.resource.getResourceId());
    resources.authenticationEntryPoint(new RefreshTokenAuthenticationEntryPoint());
    resources.tokenStore(jdbcTokenStore());
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated();
  }

  @Autowired
  public void remoteTokenServices(RemoteTokenServices remoteTokenServices, RestTemplate restTemplate){
    remoteTokenServices.setRestTemplate(restTemplate);
  }


}
