package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 13:05
 */
@Data
public class SaveActCmd {

  private Long id;

  private String username;

  private String password;

  private String nickname;

  private String email;

  private String phone;
}
