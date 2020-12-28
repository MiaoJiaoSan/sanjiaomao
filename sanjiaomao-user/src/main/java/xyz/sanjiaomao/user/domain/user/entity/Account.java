package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 22:59
 */
@Data
public class Account {

  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;

}
