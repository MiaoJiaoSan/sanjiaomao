package xyz.sanjiaomao.auth.application.cmd.opt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCmd {

  private String username;

  private String password;
}
