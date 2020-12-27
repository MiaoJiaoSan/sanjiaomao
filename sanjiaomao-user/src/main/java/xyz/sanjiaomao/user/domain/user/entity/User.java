package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * User root
 *
 * @author lyf
 * @date 2020-11-09
 */
@Data
@Entity(name = "user")
public class User {
  /**
   * id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 姓名
   */
  @Column(name = "name", nullable = false, length = 20)
  private String name;
  /**
   * 年龄
   */
  @Column(name = "age", nullable = false)
  private Integer age;
  /**
   * 性别
   */
  @Column(name = "gender", nullable = false)
  private Integer gender;
  /**
   * 身份证
   */
  @Column(name = "id_card", nullable = false, length = 20)
  private String idCard;

}
