package xyz.sanjiaomao.user.infrastructure.repository.mapper;


import org.apache.ibatis.annotations.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleDO;

@Mapper
public interface RoleMapper {

  int insert(RoleDO roleDO);

  int update(RoleDO roleDO);
}
