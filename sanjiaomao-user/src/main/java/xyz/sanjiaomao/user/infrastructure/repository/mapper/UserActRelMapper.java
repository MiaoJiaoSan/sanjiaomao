package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

@Mapper
public interface UserActRelMapper {

  int insert(UserActRelDO userActRelDO);

  int update(UserActRelDO userActRelDO);

  UserActRelDO findByUserId(Long userId);

  UserActRelDO findByActId(Long actId);

  UserActRelDO findByUserIdAndActId(Long userId, Long actId);
}
