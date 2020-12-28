package xyz.sanjiaomao.user.infrastructure.repository.entity;

import lombok.Data;

@Data
public class UserDO {
  /**
   * id
   */
  private Long id;
  /**
   * 姓名
   */
  private String name;
  /**
   * 年龄
   */
  private Integer age;
  /**
   * 性别
   */
  private Integer gender;
  /**
   * 身份证
   */
  private String idCard;
  /**
   * 版本号
   */
  private Long version;
}
