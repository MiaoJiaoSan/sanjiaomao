package xyz.sanjiaomao.user.infrastructure.auth;

import org.springframework.data.redis.core.RedisTemplate;
import xyz.sanjiaomao.shared.constant.AuthConstant;
import xyz.sanjiaomao.user.domain.Account;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AuthFilter implements Filter {

  private final RedisTemplate<String, Account> accountRedisTemplate;

  public AuthFilter(RedisTemplate<String, Account> accountRedisTemplate) {
    this.accountRedisTemplate = accountRedisTemplate;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    Cookie[] cookies = httpServletRequest.getCookies();
    Optional<String> optional = Arrays.stream(Optional.ofNullable(cookies).orElse(new Cookie[]{}))
        .filter(cookie -> Objects.equals(cookie.getName(), AuthConstant.TOKEN)).map(Cookie::getValue).findFirst();
    if (optional.isPresent()) {
      String token = optional.get();
      Account account = accountRedisTemplate.opsForValue().get(token);
      if (Objects.isNull(account)) {
        publicURI(httpServletRequest, response, chain);
        return;
      }
      accountRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
      AuthConstant.ACCOUNT_ID.set(account.getId());
      try {
        chain.doFilter(httpServletRequest, response);
      } finally {
        AuthConstant.ACCOUNT_ID.remove();
      }
      return;
    }
    publicURI(httpServletRequest, response, chain);
  }

  private void publicURI(HttpServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String uri = request.getRequestURI();
    if (uri.startsWith(AuthConstant.ACCESS_URI)) {
      chain.doFilter(request, response);
      return;
    }
    request.getRequestDispatcher("/public/authentication").forward(request, response);

  }
}
