package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


  @Override
  public AccountDO save(AccountDO account) {
    return null;
  }
}
