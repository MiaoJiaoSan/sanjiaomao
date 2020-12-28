package xyz.sanjiaomao.user.application.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.service.AccountDomainService;
import xyz.sanjiaomao.user.interfaces.assembler.AccountAssembler;
import xyz.sanjiaomao.user.interfaces.dto.AccountDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:43
 */
@Service
public class AccountOptService {

  @Autowired
  private AccountAssembler accountAssembler;
  @Autowired
  private AccountDomainService accountDomainService;

  @Transactional
  public Boolean save(AccountDTO dto) {
    Account account = accountAssembler.convert(dto);
    account.setUsername("sanjiaomao");
    account.setPassword("sanjiaomao");
    return accountDomainService.save(account);
  }

}
