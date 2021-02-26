package xyz.sanjiaomao.user.infrastructure.factory;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.shared.cmd.RegistryOpt;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.infrastructure.dao.AccountDAO;

@Mapper(componentModel = "spring")
public interface AccountFactory {

  static Account create(RegistryOpt registryOpt){
    return new Account(registryOpt.getAccount(), registryOpt.getPassword(), null);
  }

  static AccountDAO create(Account account){
    long id = SnowflakeUtil.ACCOUNT.nextId();
    AccountDAO dao = new AccountDAO();
    dao.setId(id);
    dao.setAccount(account.getAccount());
    dao.setNickname(account.getNickname());
    dao.setPassword(account.getPassword());
    return dao;
  }

  static Account load(AccountDAO dao){
    return new Account(dao.getAccount(), dao.getPassword(), null);
  }

}
