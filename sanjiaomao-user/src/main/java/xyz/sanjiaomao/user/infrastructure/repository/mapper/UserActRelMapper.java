package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

public interface UserActRelMapper {

  int insert(UserActRelDO userActRel);

  int update(UserActRelDO userActRel);

  UserActRelDO findByUserId(Long userId);

  UserActRelDO findByActId(Long actId);

  UserActRelDO findByUserIdAndActId(Long userId, Long actId);
}
