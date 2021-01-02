package xyz.sanjiaomao.auth.application.cmd.opt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCmd {

  @NotNull(message = "用户名不能为空")
  private String username;

  @NotNull(message = "密码不能为空")
  private String password;
}
