package xyz.sanjiaomao.auth.interfaces.facade;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.sanjiaomao.auth.application.cmd.opt.LoginCmd;
import xyz.sanjiaomao.shared.dto.AccountDTO;

import javax.security.auth.message.AuthException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:13
 */
@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private RestTemplate restTemplate;


  @PostMapping
  private Boolean login(LoginCmd cmd) throws AuthException {
    Map<String, String> variable = new HashMap<>();
    variable.put("username", cmd.getUsername());
    variable.put("password", cmd.getPassword());
    AccountDTO dto = restTemplate.getForObject("http://user/account", AccountDTO.class, variable);
    Assert.notNull(dto, AuthException::new);
    return true;
  }
}
