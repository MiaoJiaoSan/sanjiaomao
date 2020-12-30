package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.repository.ActUserRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.ActUserRelMapper;

import java.util.Optional;

@Repository
public class ActUserRelRepositoryImpl implements ActUserRelRepository {

  @Autowired
  private ActUserRelMapper actUserRelMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public ActUserRelDO save(ActUserRelDO actUserRelDO) {
    ActUserRelDO persistence = actUserRelMapper.findByUserIdAndActId(actUserRelDO.getUserId(), actUserRelDO.getActId());
    Optional<ActUserRelDO> optional = Optional.ofNullable(persistence);
    if(optional.isPresent()){
      actUserRelDO.setId(persistence.getId());
      actUserRelMapper.update(actUserRelDO);
    } else {
      actUserRelMapper.insert(actUserRelDO);
    }
    return actUserRelDO;
  }
}
