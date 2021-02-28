package xyz.sanjiaomao.user.application.event.handler;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.user.application.event.AccountEvent;
import xyz.sanjiaomao.user.domain.Account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 14:48
 */
@Component
public class AccountEventHandler {

  @Autowired
  private RedisTemplate<String, Account> accountRedisTemplate;
  @Autowired(required = false)
  private HttpServletResponse response;
  @Autowired(required = false)
  private HttpServletRequest request;

  @EventListener
  public void handle(AccountEvent event) {
    Account account = event.getSource();
    account.checkPassword(event.getPassword());
    Cookie[] cookies = Optional.ofNullable(request.getCookies()).orElse(new Cookie[0]);
    Optional<Cookie> optional = Arrays.stream(cookies).findFirst();
    String token = optional.isPresent() ? optional.get().getValue() :
        AuthConstant.TOKEN_PREFIX + IdUtil.simpleUUID();
    store(token, event.getSource());
  }

  private void store(String token, Account account) {
    accountRedisTemplate.opsForValue().set(token, account);
    accountRedisTemplate.expire(token, 30, TimeUnit.MINUTES);
    response.addCookie(new Cookie(AuthConstant.TOKEN, token));
  }


}
