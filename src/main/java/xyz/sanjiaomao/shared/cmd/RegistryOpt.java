package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistryOpt {

  @NotNull(message = "账号不能为空")
  @Size(min = 6, max = 20)
  private String account;

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
