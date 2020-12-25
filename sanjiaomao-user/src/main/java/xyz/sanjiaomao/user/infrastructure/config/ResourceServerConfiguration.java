package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import xyz.sanjiaomao.user.infrastructure.config.filter.LogFilter;

@SpringBootConfiguration
public class ResourceServerConfiguration  implements ResourceServerConfigurer {


  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.NEVER);
    http.addFilterBefore(new LogFilter(), WebAsyncManagerIntegrationFilter.class);
  }


}
