package xyz.sanjiaomao.user.infrastructure.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpRequestAuthWrapper extends HttpServletRequestWrapper {
  /**
   * Constructs a request object wrapping the given request.
   *
   * @param request The request to wrap
   * @throws IllegalArgumentException if the request is null
   */
  public HttpRequestAuthWrapper(HttpServletRequest request) {
    super(request);
  }



}
