package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

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

  private Long id;

  private String name;

  private Integer age;

  private Integer gender;

  private String idCard;
}
