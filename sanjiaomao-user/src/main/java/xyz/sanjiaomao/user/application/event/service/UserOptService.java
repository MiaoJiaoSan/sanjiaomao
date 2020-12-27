package xyz.sanjiaomao.user.application.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.domain.user.service.UserOptDomainService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:30
 */
@Service
public class UserOptService {
  @Autowired
  private UserOptDomainService userOptDomainService;
  @Autowired
  private AccountRepository accountRepository;


  public Boolean save(){
//    accountRepository.findAccountByUsernameAndPassword()
    return false;
  }
}
