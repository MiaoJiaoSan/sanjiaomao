package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 18:55
 */
@Data
public class RemoveRoleCmd {

  @NotNull(message = "账号不能为空")
  private Long actId;

  @NotNull(message = "角色不能为空")
  private Long roleId;
}
