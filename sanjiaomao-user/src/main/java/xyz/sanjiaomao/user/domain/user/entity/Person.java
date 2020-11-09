package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;

/**
 * person
 * @author lyf
 * @date 2020-11-09
 */
@Data
public class Person {
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
   * 身份证
   */
  private String idCard;

}
