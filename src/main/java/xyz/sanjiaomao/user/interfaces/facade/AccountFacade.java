package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.cmd.LoginOpt;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.cmd.AccountService;

@RequestMapping("/public/account")
@RestController
public class AccountFacade {

  @Autowired
  private AccountService accountService;


  @PostMapping("/registry")
  public ResultDTO registry(RegistryOpt opt){
    return accountService.registry(opt);
  }

  @PostMapping("/login")
  public ResultDTO login(LoginOpt opt){
    return accountService.login(opt);
  }

}

