package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 18:56
 */
@Data
public class ModifyUserCmd implements AccountId {

  @NotNull(message = "账号id不能为空")
  private Long accountId;

  @NotNull(message = "年龄不能为空")
  private Integer age;

  @NotNull(message = "性别不能为空")
  private String gender;

  @NotNull(message = "移动电话不能为空")
  private String mobile;

  @NotNull(message = "邮箱不能为空")
  private String email;
}
