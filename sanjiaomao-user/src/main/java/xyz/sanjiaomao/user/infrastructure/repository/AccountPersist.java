package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-28 00:14
 */
@Repository
public class AccountPersist {

  @Autowired
  private AccountRepository accountRepository;

  @Transactional
  public Account save(Account account) {
    Account persist = accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
    persist.setEmail(account.getEmail());
    persist.setPhone(account.getPhone());
    return accountRepository.save(account);
  }
}
