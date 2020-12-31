package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;

@Mapper
public interface ActUserRelMapper {

  int insert(ActUserRelDO actUserRelDO);

  int update(ActUserRelDO actUserRelDO);

  ActUserRelDO findByUserId(Long userId);

  ActUserRelDO findByActId(Long actId);

  ActUserRelDO findByUserIdAndActId(@Param("userId") Long userId, @Param("actId") Long actId);
}
