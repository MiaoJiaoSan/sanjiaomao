package xyz.sanjiaomao.user.domain.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.application.cmd.opt.AddResourceCmd;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyPrivilegeCmd;
import xyz.sanjiaomao.user.domain.role.Role;
import xyz.sanjiaomao.user.domain.role.event.AddResourceEvent;
import xyz.sanjiaomao.user.domain.role.event.ModifyPrivilegeEvent;
import xyz.sanjiaomao.user.domain.role.repository.RoleRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 16:46
 */
@Service
public class RoleDomainService {

  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;


  public Boolean save(Role role) {
    return roleRepository.save(role);
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean addResource(AddResourceCmd cmd) {
    eventPublisher.publishEvent(new AddResourceEvent(cmd.getRoleId(), cmd.getResourceId(), cmd.getPrivilege()));
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modifyPrivilege(ModifyPrivilegeCmd cmd) {
    eventPublisher.publishEvent(new ModifyPrivilegeEvent(cmd.getRoleId(), cmd.getResourceId(), cmd.getPrivilege()));
    return true;
  }
}
