package xyz.sanjiaomao.user.domain.user.repository;

import xyz.sanjiaomao.user.domain.user.User;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:11
 */
public interface UserRepository {

  Boolean save(User user);

  Boolean modify(User user);


  UserDO findById(Long id);
}
