package xyz.sanjiaomao.user.domain.account.repository;

import xyz.sanjiaomao.user.domain.account.Account;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:10
 */
public interface AccountRepository {

  Boolean save(Account account);

  Account findActById(Long id);

  Boolean modify(Account account);
}
