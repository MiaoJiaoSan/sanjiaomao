package xyz.sanjiaomao.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * sanjiaomao-user
 *
 * @author lyf
 * @date 2020-11-09
 */
@SpringCloudApplication
@EnableEurekaClient
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
