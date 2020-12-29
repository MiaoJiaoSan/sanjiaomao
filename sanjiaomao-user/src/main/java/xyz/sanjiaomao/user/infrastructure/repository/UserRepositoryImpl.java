package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.UserMapper;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDO save(UserDO userDO) {
    UserDO persistence = userMapper.findById(userDO.getId());
    Optional<UserDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      userDO.setId(persistence.getId());
      userDO.setVersion(persistence.getVersion());
      userMapper.update(userDO);
    } else {
      userMapper.insert(userDO);
    }
    return userDO;
  }
}
