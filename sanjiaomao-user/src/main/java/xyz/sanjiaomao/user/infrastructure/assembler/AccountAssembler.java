package xyz.sanjiaomao.user.infrastructure.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import xyz.sanjiaomao.user.domain.account.Account;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:51
 */
@Mapper(componentModel = "spring")
public interface AccountAssembler {


  AccountDO convert(Account account);

  Account convert(AccountDO accountDO);

  void convert(Account account, @MappingTarget AccountDO accountDO);
}
