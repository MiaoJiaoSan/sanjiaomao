package xyz.sanjiaomao.user.domain;

import cn.hutool.core.lang.Assert;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Account implements Serializable {

  private static final long serialVersionUID = -1L;

  private Long id;

  private String username;

  private String password;

  private String nickname;

  public Account(Long id) {
    this.id = id;
  }

  public static Account newAccount(Long id, String username, String password, String nickname) {
    Account accountDomain = new Account(id);
    accountDomain.setUsername(username);
    accountDomain.setPassword(password);
    accountDomain.setNickname(nickname);
    return accountDomain;
  }


  public void checkPassword(String inputPassword) {
    Assert.isTrue(Objects.equals(inputPassword, this.password), "密码不一致");
  }

}
