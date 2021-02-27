package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.domain.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.db.AccountDAO;
import xyz.sanjiaomao.user.infrastructure.db.AccountDO;
import xyz.sanjiaomao.user.infrastructure.factory.AccountConvert;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 13:45
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  private AccountDAO accountDAO;

  @Override
  public void save(Account account) {
    AccountDO accountDO = AccountConvert.serialize(account);
    accountDAO.save(accountDO);
  }

  @Override
  public Account findByUsername(String account) {
    AccountDO accountDO = accountDAO.findByUsername(account);
    return AccountConvert.deserialize(accountDO);
  }
}
