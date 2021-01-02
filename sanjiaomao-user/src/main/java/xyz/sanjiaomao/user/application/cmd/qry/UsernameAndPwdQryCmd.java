package xyz.sanjiaomao.user.application.cmd.qry;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 13:20
 */
@Data
public class UsernameAndPwdQryCmd {

  @NotNull(message = "用户名不能为空")
  private String username;

  @NotNull(message = "密码不能为空")
  private String password;
}
