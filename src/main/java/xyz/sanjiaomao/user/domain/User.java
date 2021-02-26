package xyz.sanjiaomao.user.domain;

import lombok.Data;

/**
 * @author miaojiaosan
 */
@Data
public class User {

  private static final long serialVersionUID = -1L;

  private String name;

  private String gender;

  private Integer age;

  public User(String name, String gender, Integer age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }
}
