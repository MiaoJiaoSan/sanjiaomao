package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.role.event.AddResourceEvent;
import xyz.sanjiaomao.user.domain.role.event.ModifyPrivilegeEvent;
import xyz.sanjiaomao.user.domain.shared.repository.RoleResourceRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleResourceRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.RoleResourceRelMapper;

import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:38
 */
public class RoleResourceRepositoryImpl implements RoleResourceRepository {

  @Autowired
  private RoleResourceRelMapper roleResourceRelMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Long roleId, Long resourceId, Integer privilege) {
    RoleResourceRelDO resourceRelDO = roleResourceRelMapper.findByRoleIdAndResourceId(roleId, resourceId);
    if(Objects.isNull(resourceRelDO)){
      RoleResourceRelDO roleResourceRelDO = new RoleResourceRelDO();
      roleResourceRelDO.setRoleId(roleId);
      roleResourceRelDO.setRoleId(resourceId);
      roleResourceRelDO.setPrivilege(privilege);
      roleResourceRelMapper.insert(roleResourceRelDO);
    }
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(Long roleId, Long resourceId, Integer privilege) {
    RoleResourceRelDO resourceRelDO = roleResourceRelMapper.findByRoleIdAndResourceId(roleId, resourceId);
    if(Objects.nonNull(resourceRelDO)) {
      resourceRelDO.setPrivilege(privilege);
      roleResourceRelMapper.update(resourceRelDO);
    }
    return true;
  }

  @EventListener
  @Transactional(rollbackFor = Exception.class)
  public void listener(AddResourceEvent event){
    save(event.getRoleId(), event.getResourceId(), event.getPrivilege());
  }

  @EventListener
  @Transactional(rollbackFor = Exception.class)
  public void listener(ModifyPrivilegeEvent event){
    modify(event.getRoleId(), event.getResourceId(), event.getPrivilege());
  }


}
