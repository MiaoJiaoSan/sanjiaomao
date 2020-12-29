package xyz.sanjiaomao.user.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:40
 */
@Data
public class AccountDTO {
  @NotNull(message = "用户id不能为空")
  private Long id;
  @NotNull(message = "用户nickname不能为空")
  private String nickname;
  @NotNull(message = "邮箱不能为空")
  private String email;
  @NotNull(message = "电话不能为空")
  private String phone;

}
