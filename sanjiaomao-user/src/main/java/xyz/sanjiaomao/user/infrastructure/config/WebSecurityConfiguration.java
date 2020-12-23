package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@SpringBootConfiguration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.NEVER);
  }


}
