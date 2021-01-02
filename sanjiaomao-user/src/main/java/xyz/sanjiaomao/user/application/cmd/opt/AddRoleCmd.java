package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddRoleCmd {
  @NotNull(message = "账号不能为空")
  private Long actId;

  @NotNull(message = "角色不能为空")
  private Long roleId;
}
