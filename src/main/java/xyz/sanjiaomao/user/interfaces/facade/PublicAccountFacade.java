package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.shared.cmd.LoginOpt;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.AccountOptService;
import xyz.sanjiaomao.user.application.AccountQryService;

@RequestMapping("/public/account")
@RestController
public class PublicAccountFacade {

  @Autowired
  private AccountOptService accountOptService;
  @Autowired
  private AccountQryService accountQryService;


  @PostMapping("/registry")
  public ResultDTO registry(@Validated @RequestBody RegistryOpt opt){
    return accountOptService.registry(opt);
  }

  @PostMapping("/login")
  public ResultDTO login(@Validated @RequestBody LoginOpt opt){
    return accountOptService.login(opt);
  }

  @GetMapping("/exist/{account}")
  public ResultDTO exist(@PathVariable String account){
    return accountQryService.exist(account);
  }

}

