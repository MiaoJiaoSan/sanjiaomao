package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.cmd.opt.AddResourceCmd;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyPrivilegeCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveRoleCmd;
import xyz.sanjiaomao.user.application.service.RoleOptService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 19:10
 */
@RestController
@RequestMapping("/role")
public class RoleOptController {

  @Autowired
  private RoleOptService roleOptService;

  @PostMapping
  public ResultDTO<Boolean> save(@RequestBody @Validated SaveRoleCmd cmd) {
    return new ResultDTO<>(roleOptService.save(cmd));
  }

  @PostMapping("/addResource")
  public ResultDTO<Boolean> addResource(@RequestBody @Validated AddResourceCmd cmd) {
    return new ResultDTO<>(roleOptService.addResource(cmd));
  }

  @PutMapping("/modifyPrivilege")
  public ResultDTO<Boolean> modifyPrivilege(@RequestBody @Validated ModifyPrivilegeCmd cmd) {
    return new ResultDTO<>(roleOptService.modifyPrivilege(cmd));
  }
}
