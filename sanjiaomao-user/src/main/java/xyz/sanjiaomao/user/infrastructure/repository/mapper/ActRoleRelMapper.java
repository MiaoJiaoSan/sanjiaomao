package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActRoleRelDO;

@Mapper
public interface ActRoleRelMapper {

  int insert(ActRoleRelDO actRoleRelDO);

  int update(ActRoleRelDO actRoleRelDO);
}
