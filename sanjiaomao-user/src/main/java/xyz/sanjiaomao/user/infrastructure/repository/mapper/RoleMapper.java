package xyz.sanjiaomao.user.infrastructure.repository.mapper;


import org.apache.ibatis.annotations.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleDO;

import java.util.List;

@Mapper
public interface RoleMapper {

  int insert(RoleDO roleDO);

  int update(RoleDO roleDO);

  List<RoleDO> findById(Long id);

  List<RoleDO> findByIds(List<Long> roleIds);
}
