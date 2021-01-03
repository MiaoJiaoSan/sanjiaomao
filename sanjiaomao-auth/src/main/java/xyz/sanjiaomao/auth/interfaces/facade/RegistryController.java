package xyz.sanjiaomao.auth.interfaces.facade;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.sanjiaomao.auth.application.cmd.opt.LoginCmd;
import xyz.sanjiaomao.auth.application.cmd.opt.RegistryCmd;
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
 * create by 2021-01-01 23:15
 */
@RestController
@RequestMapping("/registry")
public class RegistryController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LoginOptService loginOptService;

  @PostMapping
  public ResultDTO<Boolean> registry(@RequestBody @Validated RegistryCmd cmd) throws AuthException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
    headers.set("referer", AuthConstant.AUTHORIZATION);
    HttpEntity<RegistryCmd> entity = new HttpEntity<>(cmd, headers);
    ResponseEntity<Boolean> result = restTemplate.postForEntity(Resource.ACCOUNT_SAVE, entity, Boolean.class);
    if(Objects.isNull(result.getBody())){
      return new ResultDTO<>(false);
    }
    return new ResultDTO<>(loginOptService.login(new LoginCmd(cmd.getUsername(), cmd.getPassword())));
  }
}
