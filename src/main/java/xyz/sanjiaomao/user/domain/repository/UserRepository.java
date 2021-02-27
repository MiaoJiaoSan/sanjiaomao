package xyz.sanjiaomao.user.domain.repository;

import xyz.sanjiaomao.user.domain.User;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 17:06
 */
public interface UserRepository {

  User findByAccountId(Long username);

  void save(User user);
}
