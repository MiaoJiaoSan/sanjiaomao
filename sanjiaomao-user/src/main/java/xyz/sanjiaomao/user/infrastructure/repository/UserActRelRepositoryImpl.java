package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.user.repository.UserActRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.UserActRelMapper;

import java.util.Optional;

@Repository
public class UserActRelRepositoryImpl implements UserActRelRepository {

  @Autowired
  private UserActRelMapper userActRelMapper;

  @Override
  public UserActRelDO save(UserActRelDO userActRelDO) {
    UserActRelDO persistence = userActRelMapper.findByUserIdAndActId(userActRelDO.getUserId(), userActRelDO.getActId());
    Optional<UserActRelDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      userActRelDO.setId(persistence.getId());
      userActRelMapper.insert(userActRelDO);
    } else {
      userActRelMapper.update(userActRelDO);
    }
    return userActRelDO;
  }
}
