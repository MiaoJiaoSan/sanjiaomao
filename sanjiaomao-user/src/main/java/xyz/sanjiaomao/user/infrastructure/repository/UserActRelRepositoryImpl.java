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
  public UserActRelDO save(UserActRelDO rel) {
    UserActRelDO persistence = userActRelMapper.findByUserIdAndActId(rel.getUserId(), rel.getActId());
    Optional<UserActRelDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      rel.setId(persistence.getId());
      userActRelMapper.insert(rel);
    } else {
      userActRelMapper.update(rel);
    }
    return rel;
  }
}
