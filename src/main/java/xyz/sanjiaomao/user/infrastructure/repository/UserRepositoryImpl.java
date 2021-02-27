package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.User;
import xyz.sanjiaomao.user.domain.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.db.UserDAO;
import xyz.sanjiaomao.user.infrastructure.db.UserDO;
import xyz.sanjiaomao.user.infrastructure.factory.UserConvert;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 17:06
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private UserDAO userDAO;

  @Override
  public User findByAccountId(Long username){
    UserDO userDO = userDAO.findByAccountId(username);
    return UserConvert.deserialize(userDO);
  }

  @Override
  public void save(User user) {
    UserDO userDO = UserConvert.serialize(user);
    userDAO.save(userDO);
  }
}
