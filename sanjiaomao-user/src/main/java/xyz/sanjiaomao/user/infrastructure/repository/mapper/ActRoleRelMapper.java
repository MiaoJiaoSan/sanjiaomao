package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActRoleRelDO;

import java.util.List;

@Mapper
public interface ActRoleRelMapper {

  int insert(ActRoleRelDO actRoleRelDO);

  int update(ActRoleRelDO actRoleRelDO);

  List<ActRoleRelDO> findByActId(Long id);

  ActRoleRelDO findByActIdAndRoleId(@Param("actId") Long actId, @Param("roleId") Long roleId);

  int deleteById(Long id);

  int deleteByActId(Long id);

  void batchInsert(List<ActRoleRelDO> relations);
}
