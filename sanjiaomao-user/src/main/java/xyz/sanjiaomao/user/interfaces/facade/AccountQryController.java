package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.cmd.qry.UsernameAndPwdQryCmd;
import xyz.sanjiaomao.user.application.service.AccountQryService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:25
 */
@RestController
@RequestMapping("/accountQry")
public class AccountQryController {

  @Autowired
  private AccountQryService accountQryService;

  @GetMapping
  public AccountDTO findByUsernameAndPassword(@Validated UsernameAndPwdQryCmd cmd) {
    return accountQryService.findByUsernameAndPassword(cmd);
  }

}
