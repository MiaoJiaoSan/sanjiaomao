package xyz.sanjiaomao.user.infrastructure.repository.entity;

import lombok.Data;

@Data
public class AccountDO {

  private Long id;

  private String username;

  private String password;

  private String email;

  private String phone;

  private byte[] photo;

  private Long version;

}
