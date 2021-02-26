package xyz.sanjiaomao.user.application.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.cmd.LoginOpt;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.domain.service.AccountDomainService;
import xyz.sanjiaomao.user.infrastructure.factory.AccountFactory;

@Service
public class AccountService {

  @Autowired
  private AccountFactory accountFactory;

  @Autowired
  private AccountDomainService accountDomainService;



  public ResultDTO registry(RegistryOpt opt){
    return accountDomainService.registry(opt);
  }


  public ResultDTO login(LoginOpt opt){
    return accountDomainService.login(opt);
  }

}
