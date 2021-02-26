package xyz.sanjiaomao.user.infrastructure.auth;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import xyz.sanjiaomao.shared.constant.Token;
import xyz.sanjiaomao.user.domain.Account;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
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
    String uri = httpServletRequest.getRequestURI();


    Cookie[] cookies = httpServletRequest.getCookies();
    Optional<Cookie> optional = Arrays.stream(Optional.ofNullable(cookies).orElse(new Cookie[]{}))
        .filter(cookie -> Objects.equals(cookie.getName(), Token.TOKEN)).findFirst();
    if(optional.isPresent()){
      String token = optional.get().getValue();
      Account account = accountRedisTemplate.opsForValue().get(token);
      if(Objects.isNull(account) ){
        return;
      }
      accountRedisTemplate.expire(token,30L, TimeUnit.MINUTES);
    }
    chain.doFilter(httpServletRequest, response);
    if(uri.startsWith(Token.ACCESS_URI)) {
      chain.doFilter(httpServletRequest, response);
    }
  }
}
