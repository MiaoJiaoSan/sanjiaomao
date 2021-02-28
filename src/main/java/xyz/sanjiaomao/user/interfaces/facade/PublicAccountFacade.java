package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.cmd.AccountEventCmd;
import xyz.sanjiaomao.shared.cmd.RegistryCmd;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.AccountCmdService;

@RequestMapping("/public/account")
@RestController
public class PublicAccountFacade {

  @Autowired
  private AccountCmdService accountCmdService;


  @PostMapping
  public ResultDTO registry(@Validated @RequestBody RegistryCmd cmd) {
    accountCmdService.accountRegistry(cmd);
    return new ResultDTO(true);
  }

  @PostMapping("/login")
  public ResultDTO loginEvent(@Validated @RequestBody AccountEventCmd cmd) {
    accountCmdService.loginEvent(cmd);
    return new ResultDTO(true);
  }


}

