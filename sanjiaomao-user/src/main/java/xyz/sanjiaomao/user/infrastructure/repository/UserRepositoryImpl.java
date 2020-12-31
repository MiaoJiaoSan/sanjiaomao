package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.assembler.UserDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.UserMapper;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserDomainAssembler userDomainAssembler;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(UserAggregation aggregation) {
    User user = aggregation.getUser();
    UserDO userDO = userMapper.findById(user.getId());

    if(!Optional.ofNullable(userDO).isPresent()){
      userMapper.insert(userDomainAssembler.convert(user));
    } else {
      userDomainAssembler.convert(user, userDO);
      userMapper.update(userDO);
    }
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public UserDO findById(Long id){
    return userMapper.findById(id);
  }
}
