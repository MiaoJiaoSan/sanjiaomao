package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import xyz.sanjiaomao.user.infrastructure.config.filter.LogFilter;

@SpringBootConfiguration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<LogFilter> logFilter() {
    FilterRegistrationBean<LogFilter> filterRegistrationBean = new FilterRegistrationBean<>(new LogFilter());
    filterRegistrationBean.setOrder(0);
    filterRegistrationBean.setName("logFilter");
    return filterRegistrationBean;
  }

}
