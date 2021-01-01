package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

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

  private Long id;

  private Long actId;

  private String name;

  private Integer age;

  private Integer gender;

  private String idCard;
}
