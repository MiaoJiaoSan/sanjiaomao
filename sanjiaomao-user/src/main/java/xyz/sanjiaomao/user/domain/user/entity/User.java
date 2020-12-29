package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User root
 *
 * @author lyf
 * @date 2020-11-09
 */
@Data
@AllArgsConstructor
public class User {
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

  public User(Long id){
    this.id = id;
  }


}
