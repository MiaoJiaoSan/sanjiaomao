package xyz.sanjiaomao.auth.interfaces.facade;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.sanjiaomao.auth.application.cmd.opt.LoginCmd;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.shared.constant.Resource;
import xyz.sanjiaomao.shared.dto.AccountDTO;

import javax.security.auth.message.AuthException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
  private RestTemplate restTemplate;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  @Autowired
  private HttpServletResponse httpServletResponse;


  @PostMapping
  private Boolean login(@RequestBody @Validated LoginCmd cmd) throws AuthException {
    AccountDTO dto = restTemplate.getForObject(Resource.ACCOUNT, AccountDTO.class, cmd.getUsername(), cmd.getPassword());
    Assert.notNull(dto, AuthException::new);
    String token = AuthConstant.TOKEN_PREFIX + IdUtil.simpleUUID();
    redisTemplate.opsForValue().set(token, JSONUtil.toJsonStr(dto));
    redisTemplate.expire(token, 30, TimeUnit.MINUTES);
    httpServletResponse.addCookie(new Cookie(AuthConstant.authorization, token));
    return true;
  }
}
