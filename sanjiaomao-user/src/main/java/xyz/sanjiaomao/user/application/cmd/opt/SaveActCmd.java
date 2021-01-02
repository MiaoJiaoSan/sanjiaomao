package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 13:05
 */
@Data
public class SaveActCmd {

  @NotNull(message = "用户名不能为空")
  private String username;

  @NotNull(message = "密码不能为空")
  private String password;

  @NotNull(message = "nickname不能为空")
  private String nickname;

  @NotNull(message = "email不能为空")
  private String email;

  @NotNull(message = "电话不能为空")
  private String phone;
}
