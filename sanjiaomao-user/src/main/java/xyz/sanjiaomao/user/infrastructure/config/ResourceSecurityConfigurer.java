package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SpringBootConfiguration
public class ResourceSecurityConfigurer extends ResourceServerConfigurerAdapter {

  private ResourceServerProperties resource;

  public ResourceSecurityConfigurer(ResourceServerProperties resource) {
    this.resource = resource;
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources)
      throws Exception {
    resources.resourceId(this.resource.getResourceId());
//    resources.authenticationEntryPoint(new RefreshTokenAuthenticationEntryPoint());
//    resources.tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated();

  }
}
