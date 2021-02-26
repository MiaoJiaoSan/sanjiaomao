package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.constant.Token;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.user.application.AccountQryService;
import xyz.sanjiaomao.user.domain.Account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 00:46
 */
@RequestMapping("/account")
@RestController
public class AccountFacade {
  @Autowired
  private AccountQryService accountQryService;
  @Autowired
  private RedisTemplate<String, Account> accountRedisTemplate;
  @Autowired(required = false)
  private HttpServletRequest request;


  @GetMapping("/{account}")
  public AccountDTO account(@PathVariable String account){
    Cookie[] cookies = request.getCookies();
    Optional<String> token = Arrays.stream(cookies).filter(cookie -> Objects.equals(cookie.getName(), Token.TOKEN)).map(Cookie::getValue).findFirst();
    Account curAccount = accountRedisTemplate.opsForValue().get(token.get());
    assert curAccount != null: "登录用户不能为空";
    assert Objects.equals(curAccount.getAccount(), account): "账号不一致";
    return accountQryService.findByAccount(account);
  }
}
