package xyz.sanjiaomao.shared.autoconfig;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.shared.dto.ResultDTO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 20:08
 */
public class AuthFilter implements Filter {

  private final RedisTemplate<String, String> redisTemplate;

  public AuthFilter(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    if(Objects.equals(httpServletRequest.getHeader("referer"),AuthConstant.AUTHORIZATION )){
      chain.doFilter(request, response);
      return;
    }
    ResultDTO<Boolean> dto = new ResultDTO<>(false);
    dto.setMessage("请重新登录");
    String result = JSONUtil.toJsonStr(dto);
    Cookie[] cookies = httpServletRequest.getCookies();
    if (Objects.isNull(cookies)) {
      PrintWriter writer = response.getWriter();
      writer.write(result);
      return;
    }
    Optional<Cookie> authCookie = Arrays.stream(cookies).filter(cookie -> Objects.equals(cookie.getName(), AuthConstant.AUTHORIZATION)).findFirst();
    if (!authCookie.isPresent()) {
      PrintWriter writer = response.getWriter();
      writer.write(result);
      return;
    }
    String oldToken = authCookie.get().getValue();
    DefaultRedisScript<String> script = new DefaultRedisScript<>(AuthConstant.TOKEN_CHECK);
    script.setResultType(String.class);
    String executeRst = redisTemplate.execute(script, Collections.singletonList(oldToken));
    if (Objects.isNull(executeRst)) {
      PrintWriter writer = response.getWriter();
      writer.write(result);
      return;
    }

    JSONObject userInfo = JSONUtil.parseObj(executeRst);
    DefaultRedisScript<Long> flush = new DefaultRedisScript<>(AuthConstant.TOKEN_SCRIPT);
    flush.setResultType(Long.class);
    String token = AuthConstant.TOKEN_PREFIX + IdUtil.simpleUUID();
    redisTemplate.execute(flush, Arrays.asList(token, AuthConstant.USER_ID+userInfo.getStr("id"), oldToken), executeRst, token);
    HttpServletResponse httpServletResponse = (HttpServletResponse)response;
    httpServletResponse.addCookie(new Cookie(AuthConstant.AUTHORIZATION, token));
    chain.doFilter(request, response);


  }
}
