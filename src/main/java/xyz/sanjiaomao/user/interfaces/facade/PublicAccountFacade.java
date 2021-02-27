package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.cmd.LoginCmd;
import xyz.sanjiaomao.shared.cmd.RegistryCmd;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.AccountOptService;

@RequestMapping("/public/account")
@RestController
public class PublicAccountFacade {

  @Autowired
  private AccountOptService accountOptService;


  @PostMapping
  public ResultDTO registry(@Validated @RequestBody RegistryCmd opt) {
    accountOptService.accountRegistry(opt);
    return new ResultDTO(true);
  }

  @PostMapping("/login")
  public ResultDTO login(@Validated @RequestBody LoginCmd opt) {
    accountOptService.accountLogin(opt);
    return new ResultDTO(true);
  }


}

