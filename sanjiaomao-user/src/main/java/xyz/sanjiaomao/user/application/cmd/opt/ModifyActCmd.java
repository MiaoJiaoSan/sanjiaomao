package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 18:31
 */
@Data
public class ModifyActCmd {

  private Long id;

  private String username;

  private String password;

  private String nickname;

  private String email;

  private String phone;
}
