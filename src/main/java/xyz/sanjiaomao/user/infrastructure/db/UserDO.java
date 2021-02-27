package xyz.sanjiaomao.user.infrastructure.db;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class UserDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String account;

  @Column
  private String name;

  @Column
  private Integer age;

  @Column
  private String gender;

  @Column
  private String idCard;

  @Column
  private String mobile;

  @Column
  private String email;
}
