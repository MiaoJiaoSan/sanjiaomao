package xyz.sanjiaomao.auth.infrastructure.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import xyz.sanjiaomao.auth.infrastructure.config.filter.AuthFilter;
import xyz.sanjiaomao.auth.infrastructure.config.filter.LogFilter;

@SpringBootConfiguration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<LogFilter> logFilter() {
    FilterRegistrationBean<LogFilter> filterRegistrationBean = new FilterRegistrationBean<>(new LogFilter());
    filterRegistrationBean.setOrder(0);
    filterRegistrationBean.setName("logFilter");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean<AuthFilter> authFilter(RedisTemplate<String, String> redisTemplate) {
    FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean<>(new AuthFilter(redisTemplate));
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.setName("authFilter");
    return filterRegistrationBean;
  }

}
