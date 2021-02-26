package xyz.sanjiaomao.user.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Account {

  private static final long serialVersionUID = -1L;

  private String account;

  private String password;

  private String nickname;

  private User user;


  public Account(String account) {
    this.account = account;
  }


  public Account(String account, String password, User user) {
    this.account = account;
    this.password = password;
    this.user = user;
  }

  public Boolean checkPassword(String rePassword){
    return Objects.equals(this.password,rePassword);
  }

}
