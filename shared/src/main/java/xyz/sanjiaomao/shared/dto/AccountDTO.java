package xyz.sanjiaomao.shared.dto;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:19
 */
@Data
public class AccountDTO {

  private Long id;

  private String username;

  private String password;

  private String nickname;

  private String email;

  private String phone;
}
