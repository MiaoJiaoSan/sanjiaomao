package xyz.sanjiaomao.user.application;

import cn.hutool.crypto.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.cmd.LoginOpt;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.domain.service.AccountDomainService;
import xyz.sanjiaomao.user.infrastructure.factory.AccountFactory;

@Service
public class AccountOptService {

  @Autowired
  private AccountFactory accountFactory;

  @Autowired
  private AccountDomainService accountDomainService;



  public ResultDTO registry(RegistryOpt opt){
    opt.setPassword(encryption(opt.getPassword()));
    opt.setRePassword(encryption(opt.getRePassword()));
    return accountDomainService.registry(opt);
  }




  public ResultDTO login(LoginOpt opt){
    opt.setPassword(encryption(opt.getPassword()));
    return accountDomainService.login(opt);
  }

  private String encryption(String source) {
    MD5 md5 = MD5.create();
    return md5.digestHex(source);
  }
}
