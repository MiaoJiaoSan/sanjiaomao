package xyz.sanjiaomao.auth.application.cmd.opt;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:40
 */
@Data
public class RegistryCmd {

  private String username;

  private String password;

  private String nickname;

  private String email;

  private String phone;

  private String photo;
}
