package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 22:59
 */
@Data
@Entity(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "username", nullable = false, length = 20)
  private String username;
  @Column(name = "password", nullable = false, length = 20)
  private String password;
  @Column(name = "email", nullable = true, length = 64)
  private String email;
  @Column(name = "phone", nullable = true, length = 64)
  private String phone;

}
