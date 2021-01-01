package xyz.sanjiaomao.user.infrastructure.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.role.Role;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleDO;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 16:21
 */
@Mapper(componentModel = "spring")
public interface RoleAssembler {

  RoleDO convert(Role role);

  List<Role> convert(List<RoleDO> roles);
}
