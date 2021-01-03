package xyz.sanjiaomao.auth.interfaces.facade;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.sanjiaomao.auth.application.cmd.opt.LoginCmd;
import xyz.sanjiaomao.auth.application.service.LoginOptService;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.shared.constant.Resource;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.shared.dto.ResultDTO;

import javax.security.auth.message.AuthException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
  private LoginOptService loginOptService;


  @PostMapping
  private ResultDTO<Boolean> login(@RequestBody @Validated LoginCmd cmd) throws AuthException {
    Boolean login = loginOptService.login(cmd);
    return new ResultDTO<>(login, login?"登录成功":"登录失败");
  }
}
