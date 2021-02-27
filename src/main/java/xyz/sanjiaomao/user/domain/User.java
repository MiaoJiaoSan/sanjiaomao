package xyz.sanjiaomao.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author miaojiaosan
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = -1L;

  private String name;

  private Integer age;

  private String gender;

  private String idCard;

  private String mobile;

  private String email;


  public User(String name, Integer age, String gender, String idCard, String mobile, String email) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.idCard = idCard;
    this.mobile = mobile;
    this.email = email;
  }
}
