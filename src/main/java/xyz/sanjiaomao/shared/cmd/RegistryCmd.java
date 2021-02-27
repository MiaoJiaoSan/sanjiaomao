package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistryCmd {

  @NotNull(message = "用户名不能为空")
  @Size(min = 6, max = 20)
  private String username;

  @NotNull(message = "密码不能为空")
  @Size(min = 8, max = 64)
  private String password;

  @NotNull(message = "重复密码不能为空")
  @Size(min = 8, max = 64)
  private String rePassword;

  @NotNull(message = "nickname不能为空")
  @Size(min = 1, max = 12)
  private String nickname;
}
