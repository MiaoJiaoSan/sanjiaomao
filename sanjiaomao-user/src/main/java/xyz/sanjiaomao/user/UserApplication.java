package xyz.sanjiaomao.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

/**
 * sanjiaomao-user
 *
 * @author lyf
 * @date 2020-11-09
 */
@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {

    return new RestTemplate();
  }
}
