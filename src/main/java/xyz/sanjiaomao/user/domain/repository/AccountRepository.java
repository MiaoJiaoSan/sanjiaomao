package xyz.sanjiaomao.user.domain.repository;

import xyz.sanjiaomao.user.domain.Account;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 13:44
 */
public interface AccountRepository {

  void save(Account account);

  Account findByUsername(String account);
}
