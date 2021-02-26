package xyz.sanjiaomao.user.domain.handler;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.shared.constant.Token;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.domain.User;
import xyz.sanjiaomao.user.domain.event.LoginEvent;
import xyz.sanjiaomao.user.infrastructure.dao.UserDAO;
import xyz.sanjiaomao.user.infrastructure.factory.UserFactory;
import xyz.sanjiaomao.user.infrastructure.repository.UserRepository;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class LoginEventHandler {

  @Autowired
  private RedisTemplate<String, Account> accountRedisTemplate;
  @Autowired
  private UserRepository userRepository;
  @Autowired(required = false)
  private HttpServletResponse httpServletResponse;


  @EventListener
  public void loginEvent(LoginEvent<Account> event){
    Account account = event.getSource();
    User user = loadUser(account);
    account.setUser(user);
    String token = IdUtil.simpleUUID();
    accountRedisTemplate.opsForValue().set(token, account);
    accountRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
    httpServletResponse.addCookie(new Cookie(Token.TOKEN, token));
  }

  private User loadUser(Account account) {
    UserDAO dao = userRepository.findByAccount(account.getAccount());
    return UserFactory.load(dao);
  }

}
