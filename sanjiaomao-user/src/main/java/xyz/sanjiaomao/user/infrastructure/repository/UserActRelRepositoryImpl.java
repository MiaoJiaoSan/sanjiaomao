package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.shared.repository.UserActRelRepository;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.UserActRelMapper;

import java.util.Objects;

@Repository
public class UserActRelRepositoryImpl implements UserActRelRepository {

  @Autowired
  private UserActRelMapper userActRelMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Long userId, Long actId) {
    UserActRelDO relation = userActRelMapper.findByUserIdAndActId(userId, actId);
    if (Objects.isNull(relation)) {
      UserActRelDO userActRelDO = new UserActRelDO();
      userActRelDO.setActId(actId);
      userActRelDO.setUserId(userId);
      userActRelMapper.insert(userActRelDO);
    }
    return true;
  }

  @EventListener
  public void listener(SaveUserEvent event) {
    save(event.getUserId(), event.getActId());
  }

}
