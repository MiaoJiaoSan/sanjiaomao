package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Account {

  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;



  public Account(Long id){
    this.id = id;
  }

}
