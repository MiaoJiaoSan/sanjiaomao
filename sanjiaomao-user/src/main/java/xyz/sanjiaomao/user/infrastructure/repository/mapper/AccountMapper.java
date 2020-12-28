package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

public interface AccountMapper {


  int insert(AccountDO account);

  int update(AccountDO account);

  AccountDO findById(Long id);

  AccountDO findByUsernameAndPassword(String username, String password);
}
