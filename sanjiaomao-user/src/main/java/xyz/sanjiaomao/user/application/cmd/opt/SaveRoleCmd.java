package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 19:10
 */
@Data
public class SaveRoleCmd {

  @NotNull(message = "角色名称不能为空")
  private String name;
}
