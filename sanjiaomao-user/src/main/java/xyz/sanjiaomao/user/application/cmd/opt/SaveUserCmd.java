package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 13:04
 */
@Data
public class SaveUserCmd {

  @NotNull(message = "用户不能为空")
  private Long id;

  @NotNull(message = "账号不能为空")
  private Long actId;

  @NotNull(message = "姓名不能为空")
  private String name;

  @NotNull(message = "年龄不能为空")
  private Integer age;

  @NotNull(message = "性别不能为空")
  private Integer gender;

  @NotNull(message = "身份证不能为空")
  private String idCard;
}
