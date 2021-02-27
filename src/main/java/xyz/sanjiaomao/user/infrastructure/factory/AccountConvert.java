package xyz.sanjiaomao.user.infrastructure.factory;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.infrastructure.db.AccountDO;

@Mapper(componentModel = "spring")
public interface AccountConvert {

  static AccountDO serialize(Account account) {
    AccountDO dao = new AccountDO();
    dao.setId(account.getId());
    dao.setUsername(account.getUsername());
    dao.setNickname(account.getNickname());
    dao.setPassword(account.getPassword());
    return dao;
  }

  static Account deserialize(AccountDO accountDO) {
    return Account.newAccount(accountDO.getId(), accountDO.getUsername(), accountDO.getPassword(), accountDO.getNickname());
  }

  AccountDTO convertDTO(AccountDO dao);
}
