package xyz.sanjiaomao.auth.infrastructure.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    MDC.put("traceId", UUID.randomUUID().toString());
    chain.doFilter(request, response);
  }
}
