package xyz.sanjiaomao.user.infrastructure.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="account")
public class AccountDAO {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column
  private String account;

  @Column
  private String password;

  @Column
  private String nickname;

}
