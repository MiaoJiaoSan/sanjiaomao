package xyz.sanjiaomao.user.domain.account;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 22:59
 */
@Data
@NoArgsConstructor
public class Account {

  private Long id;
  private String username;
  private String password;
  private String nickname;
  private String email;
  private String phone;


  public Account(Long id) {
    this.id = id;
  }

  public Account(Long id, String username, String password, String nickname, String email, String phone) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
    this.email = email;
    this.phone = phone;
  }

}
