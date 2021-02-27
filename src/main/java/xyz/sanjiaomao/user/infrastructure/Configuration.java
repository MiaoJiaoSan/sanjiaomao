package xyz.sanjiaomao.user.infrastructure;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.infrastructure.auth.AuthFilter;

@SpringBootConfiguration
public class Configuration {

  @Bean
  public RedisTemplate<String, Account> accountRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Account> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(StringRedisSerializer.UTF_8);
    return template;
  }

  @Bean
  public FilterRegistrationBean<AuthFilter> filterRegistrationBean(AuthFilter authFilter) {
    FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>(authFilter);
    registrationBean.setOrder(0);
    return registrationBean;
  }

  @Bean
  public AuthFilter authFilter(RedisTemplate<String, Account> accountRedisTemplate) {
    return new AuthFilter(accountRedisTemplate);
  }
}
