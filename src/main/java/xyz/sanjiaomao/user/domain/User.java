package xyz.sanjiaomao.user.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author miaojiaosan
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = -1L;

  private Long id;

  private Long accountId;

  private String name;

  private Integer age;

  private String gender;

  private String idCard;

  private String mobile;

  private String email;

  public User(Long id) {
    this.id = id;
  }


  public static User newUser(Long id, Long accountId, String name, Integer age, String gender, String idCard, String mobile, String email){
    User user = new User(id);
    user.setId(id);
    user.setAccountId(accountId);
    user.setName(name);
    user.setAge(age);
    user.setGender(gender);
    user.setIdCard(idCard);
    user.setMobile(mobile);
    user.setEmail(email);
    return user;
  }
}
