package xyz.sanjiaomao.user.domain.user.repository;

import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:10
 */
public interface AccountRepository {

  AccountDO save(AccountDO accountDO);
}
