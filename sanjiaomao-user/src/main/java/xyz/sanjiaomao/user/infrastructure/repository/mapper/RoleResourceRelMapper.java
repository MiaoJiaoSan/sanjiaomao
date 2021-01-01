package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleResourceRelDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:39
 */
@Mapper
public interface RoleResourceRelMapper {

  int insert(RoleResourceRelDO roleResourceRelDO);

  int update(RoleResourceRelDO roleResourceRelDO);

  RoleResourceRelDO findByRoleIdAndResourceId(Long roleId, Long resourceId);
}
