package xyz.sanjiaomao.user.domain.user.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.user.entity.Account;
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
public interface AccountDomainAssembler {


  AccountDO convert(Account account);

  Account convert(AccountDO accountDO);
}
