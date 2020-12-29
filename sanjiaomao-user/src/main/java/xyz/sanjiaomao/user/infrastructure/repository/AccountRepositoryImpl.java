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
  public AccountDO save(AccountDO accountDO) {
    AccountDO persistence = accountMapper.findById(accountDO.getId());
    Optional<AccountDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      accountDO.setId(persistence.getId());
      accountDO.setVersion(persistence.getVersion());
      accountMapper.update(accountDO);
    } else {
      accountMapper.insert(accountDO);
    }
    return accountDO;
  }

  @Override
  public AccountDO findById(Long id) {
    return accountMapper.findById(id);
  }


}
