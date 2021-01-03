package xyz.sanjiaomao.auth.application.service;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.sanjiaomao.auth.application.cmd.opt.LoginCmd;
import xyz.sanjiaomao.auth.application.cmd.opt.RegistryCmd;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.shared.constant.Resource;
import xyz.sanjiaomao.shared.dto.AccountDTO;

import javax.security.auth.message.AuthException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 15:19
 */
@Service
public class LoginOptService {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  @Autowired
  private HttpServletResponse httpServletResponse;

  public Boolean login(LoginCmd cmd) throws AuthException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
    headers.set("referer", AuthConstant.AUTHORIZATION);
    HttpEntity<LoginCmd> entity = new HttpEntity<>(null, headers);
    ResponseEntity<AccountDTO> response = restTemplate.exchange(Resource.ACCOUNT_USERNAME_PASSWORD, HttpMethod.GET, entity, AccountDTO.class, cmd.getUsername(), cmd.getPassword());
    Assert.notNull(response, AuthException::new);
    AccountDTO dto = response.getBody();
    Assert.notNull(dto, AuthException::new);
    Assert.notNull(dto.getId(), AuthException::new);
    String token = AuthConstant.TOKEN_PREFIX + IdUtil.simpleUUID();
    DefaultRedisScript<Long> script = new DefaultRedisScript<>(AuthConstant.TOKEN_SCRIPT_NO_REPEAT);
    script.setResultType(Long.class);
    Long execRst = redisTemplate.execute(script, Arrays.asList(token, AuthConstant.USER_ID + dto.getId()), JSONUtil.toJsonStr(dto), token);
    Optional.ofNullable(execRst).ifPresent(rst->{
      if(Objects.equals(1L, execRst)) {
        httpServletResponse.addCookie(new Cookie(AuthConstant.AUTHORIZATION, token));
      }
    });
    return true;
  }
}
