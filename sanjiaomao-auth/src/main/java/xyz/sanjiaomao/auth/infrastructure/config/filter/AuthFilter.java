package xyz.sanjiaomao.auth.infrastructure.config.filter;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import xyz.sanjiaomao.shared.constant.AuthConstant;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.nio.charset.Charset;
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

  public AuthFilter(RedisTemplate<String, String> redisTemplate){
    this.redisTemplate = redisTemplate;
  }


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    Cookie[] cookies = httpServletRequest.getCookies();
    Optional<Cookie> authCookie = Arrays.stream(cookies).filter(cookie -> Objects.equals(cookie.getName(), AuthConstant.authorization)).findFirst();
    String token;
    if(authCookie.isPresent()){
      token = authCookie.get().getValue();

    } else {
      chain.doFilter(httpServletRequest, httpServletResponse);
      OutputStream outputStream = httpServletResponse.getOutputStream();

    }
//    Optional.ofNullable(redisTemplate.opsForValue().get(token)).ifPresent(userInfo -> {
//      try(PrintWriter writer = httpServletResponse.getWriter()){
//        writer.write("{}");
//      }catch (Exception e){
//        log.error("auth error", e);
//      }
//    });
  }


  public static class ResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;

    private ServletOutputStream out;

    public ResponseWrapper(HttpServletResponse response) {
      super(response);
      buffer = new ByteArrayOutputStream();
    }
  }
}
