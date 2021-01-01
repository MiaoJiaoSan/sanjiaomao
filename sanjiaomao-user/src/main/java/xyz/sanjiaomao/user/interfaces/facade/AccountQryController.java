package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.dto.AccountDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:25
 */
@RestController
@RequestMapping("/account")
public class AccountQryController {


  @GetMapping
  public AccountDTO findByUsernameAndPassword(String username, String password){
    return new AccountDTO();
  }

}
