package xyz.sanjiaomao.user.infrastructure.dao;

import lombok.Data;

@Data
public class AccountDAO {

  private Long id;

  private String idCard;

  private String account;

  private String password;

  private String nickname;

}
