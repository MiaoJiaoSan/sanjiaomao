package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.cmd.opt.AddResourceCmd;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyPrivilegeCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveRoleCmd;
import xyz.sanjiaomao.user.domain.role.Role;
import xyz.sanjiaomao.user.domain.role.service.RoleDomainService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 19:11
 */
@Service
public class RoleOptService {

  @Autowired
  private RoleDomainService roleDomainService;

  @Transactional(rollbackFor = Exception.class)
  public Boolean save(SaveRoleCmd cmd) {
    Role role = new Role(SnowflakeUtil.ROLE.nextId(), cmd.getName());
    return roleDomainService.save(role);
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean addResource(AddResourceCmd cmd) {
    return roleDomainService.addResource(cmd);
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modifyPrivilege(ModifyPrivilegeCmd cmd){
    return roleDomainService.modifyPrivilege(cmd);
  }
}
