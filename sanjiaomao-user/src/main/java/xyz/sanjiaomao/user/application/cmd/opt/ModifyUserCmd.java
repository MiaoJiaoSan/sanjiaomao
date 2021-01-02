package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 18:44
 */
@Data
public class ModifyUserCmd {

  @NotNull(message = "用户不能为空")
  private Long id;

  @NotNull(message = "姓名不能为空")
  private String name;

  @NotNull(message = "年龄不能为空")
  private Integer age;

  @NotNull(message = "性别不能为空")
  private Integer gender;

  @NotNull(message = "身份证不能为空")
  private String idCard;
}
