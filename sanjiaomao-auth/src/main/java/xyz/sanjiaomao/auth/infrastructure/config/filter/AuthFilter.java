package xyz.sanjiaomao.auth.infrastructure.config.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.shared.function.Branch;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:43
 */
@Slf4j
public class AuthFilter implements Filter {

  private final RedisTemplate<String, String> redisTemplate;

  public AuthFilter(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) response);
    Cookie[] cookies = httpServletRequest.getCookies();
    if (Objects.nonNull(cookies)) {
      Optional<Cookie> authCookie = Arrays.stream(cookies).filter(cookie -> Objects.equals(cookie.getName(), AuthConstant.authorization)).findFirst();
      if (authCookie.isPresent() && check(authCookie.get().getValue())) {
        return;
      }
    }
    chain.doFilter(httpServletRequest, wrapper);
    Cookie cookie = Optional.of(wrapper.getCookie()).orElse(new Cookie(AuthConstant.authorization, StrUtil.EMPTY));
    check(cookie.getValue());

  }

  public boolean check(String token) {
    return Optional.ofNullable(redisTemplate.opsForValue().get(token)).isPresent();
  }


  public static class ResponseWrapper extends HttpServletResponseWrapper {

    private Cookie cookie;

    public ResponseWrapper(HttpServletResponse response) {
      super(response);
    }

    public void setCookie(Cookie cookie) {
      this.cookie = cookie;
    }

    public Cookie getCookie() {
      return cookie;
    }

    @Override
    public void addCookie(Cookie cookie) {
      super.addCookie(cookie);
      Branch branch = () -> Objects.equals(AuthConstant.authorization, cookie.getName());
      branch.trueAndThen(() -> setCookie(cookie));
    }
  }
}
