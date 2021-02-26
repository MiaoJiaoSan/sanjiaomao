package xyz.sanjiaomao.user.infrastructure.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="user")
public class UserDAO {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column
  private String account;

  @Column
  private String idCard;
}
