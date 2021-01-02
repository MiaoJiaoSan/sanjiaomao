package xyz.sanjiaomao.shared.autoconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 20:07
 */
@SpringBootConfiguration
public class AuthFilterRegistryBean {

  @Bean
  @ConditionalOnBean(RedisTemplate.class)
  public FilterRegistrationBean<AuthFilter> authFilter(RedisTemplate<String, String> redisTemplate){
    FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>(new AuthFilter(redisTemplate));
    registrationBean.setName("authFilter");
    registrationBean.setOrder(1);
    return registrationBean;
  }

}
