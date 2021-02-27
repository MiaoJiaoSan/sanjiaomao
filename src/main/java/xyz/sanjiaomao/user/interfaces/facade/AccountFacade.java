package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.annotation.Auth;
import xyz.sanjiaomao.shared.dto.AccountDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 21:49
 */
@RequestMapping("/user")
@RestController
public class AccountFacade {

  @Auth
  @GetMapping("/{id}")
  public AccountDTO account(@PathVariable Long id) {
    return null;
  }
}
