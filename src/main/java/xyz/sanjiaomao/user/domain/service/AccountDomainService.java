package xyz.sanjiaomao.user.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.cmd.LoginOpt;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.domain.event.LoginEvent;
import xyz.sanjiaomao.user.domain.event.RegistryEvent;
import xyz.sanjiaomao.user.infrastructure.dao.AccountDAO;
import xyz.sanjiaomao.user.infrastructure.factory.AccountFactory;
import xyz.sanjiaomao.user.infrastructure.repository.AccountRepository;

@Service
public class AccountDomainService {

  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @Transactional(rollbackFor = Exception.class)
  public ResultDTO registry(RegistryOpt opt){
    Account account = AccountFactory.create(opt);
    if(!account.checkPassword(opt.getRePassword())){
      return new ResultDTO("密码不一致",false);
    }
    AccountDAO dao = AccountFactory.create(account);
    accountRepository.save(dao);
    loginEvent(account);
    return new ResultDTO(true);
  }

  @Transactional(rollbackFor = Exception.class)
  public ResultDTO login(LoginOpt opt) {
    AccountDAO dao = accountRepository.findByAccount(opt.getAccount());
    Account account = AccountFactory.load(dao);
    if(!account.checkPassword(opt.getPassword())){
      return new ResultDTO("密码错误",false);
    }
    loginEvent(account);
    return new ResultDTO(true);
  }


  public void loginEvent(Account account){
    applicationEventPublisher.publishEvent(new LoginEvent(account));
  }


}
