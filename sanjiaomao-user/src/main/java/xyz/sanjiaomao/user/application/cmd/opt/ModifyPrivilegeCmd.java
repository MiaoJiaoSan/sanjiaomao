package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 21:03
 */
@Data
public class ModifyPrivilegeCmd {

  @NotNull(message = "角色不能为空")
  private Long roleId;
  @NotNull(message = "资源不能为空")
  private Long resourceId;
  @NotNull(message = "权限不能为空")
  private Integer privilege;
}
