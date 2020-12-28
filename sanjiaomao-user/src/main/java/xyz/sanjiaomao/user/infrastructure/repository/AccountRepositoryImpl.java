package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.AccountMapper;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  private AccountMapper accountMapper;

  @Override
  public AccountDO save(AccountDO account) {
    AccountDO persistence = accountMapper.findByUsernameAndPassword(account.getUsername(), account.getPassword());
    Optional<AccountDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      account.setId(persistence.getId());
      account.setVersion(persistence.getVersion());
      accountMapper.update(account);
    } else {
      accountMapper.insert(account);
    }
    return account;
  }
}
