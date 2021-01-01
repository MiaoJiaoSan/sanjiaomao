package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.User;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.assembler.UserAssembler;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.UserMapper;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserAssembler userAssembler;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(User user) {
    userMapper.insert(userAssembler.convert(user));
    return true;
  }

  public Boolean modify(User user) {
    UserDO userDO = userMapper.findById(user.getId());
    if (Optional.ofNullable(userDO).isPresent()) {
      userAssembler.convert(user, userDO);
      userMapper.update(userDO);
    }
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public UserDO findById(Long id) {
    return userMapper.findById(id);
  }
}
