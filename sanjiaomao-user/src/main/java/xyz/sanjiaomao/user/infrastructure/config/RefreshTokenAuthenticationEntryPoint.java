package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author miaojiaosan
 */
@SpringBootConfiguration
public class RefreshTokenAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

  public static final String ERROR = "error";


  private WebResponseExceptionTranslator<?> exceptionTranslator = new DefaultWebResponseExceptionTranslator();


  @Resource
  RestTemplate restTemplate;

  @Value("${security.oauth2.client.access-token-uri}")
  private String accessTokenUri;

  @Value("${security.oauth2.client.client-id}")
  private String clientId;

  @Value("${security.oauth2.client.client-secret}")
  private String clientSecret;



  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
    try {
      String accessToken = request.getHeader("Authorization");
      assert accessToken != null;
      //解析异常，如果是401则处理
      ResponseEntity<?> result = exceptionTranslator.translate(authException);
      if (result.getStatusCode() == HttpStatus.UNAUTHORIZED) {
        Map<String, String> responseInfo = refresh(accessToken);
        if (responseInfo.get(ERROR) != null) {
          errorResponse(response, responseInfo);
        } else {
          requestWrapper(request, response, responseInfo);
        }
      } else {
        //如果不是401异常，则以默认的方法继续处理其他异常
        super.commence(request, response, authException);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 刷新
   *
   * @param accessToken accessToken
   * @return JWT Response
   * @throws IOException 异常
   */
  @SuppressWarnings("unchecked")
  private Map<String, String> refresh(String accessToken) throws IOException {
    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    formData.add("grant_type", "refresh_token");
    formData.add("refresh_token", "a21108b4-bddb-464a-a474-1ad3fd343b6a");
    formData.add("client_id", clientId);
    formData.add("client_secret", clientSecret);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//    headers.setBasicAuth(clientId, clientSecret);
    Map<String, String> responseInfo = restTemplate.exchange(accessTokenUri, HttpMethod.POST,
        new HttpEntity<>(formData, headers), Map.class).getBody();
    //如果刷新异常
    assert responseInfo != null;
    return responseInfo;
  }

  /**
   * 刷新token失败
   *
   * @param response     异常响应
   * @param responseInfo JWT Response
   * @throws IOException 异常
   */
  private void errorResponse(HttpServletResponse response, Map<String, String> responseInfo) throws IOException {
    // 返回指定格式的错误信息
    response.setStatus(401);
    response.setHeader("Content-Type", "application/json;charset=utf-8");
    response.getWriter().print("{\"code\":1,\"message\":\"" + responseInfo.get("error_description") + "\"}");
    response.getWriter().flush();
  }

  /**
   * 刷新请求头,重定向
   *
   * @param request      {@link HttpServletRequest }
   * @param response     {@link HttpServletResponse }
   * @param responseInfo {@link Map }
   * @throws ServletException 异常
   * @throws IOException      异常
   */
  private void requestWrapper(HttpServletRequest request, HttpServletResponse response, Map<String, String> responseInfo) throws ServletException, IOException {
    String accessToken = responseInfo.get("token_type") + " " + responseInfo.get("access_token");

    response.addCookie(new Cookie("access_token",responseInfo.get("access_token")));
    response.addCookie(new Cookie("token_type",responseInfo.get("token_type")));
    RequestWrapper requestWrapper = new RequestWrapper(request);
    requestWrapper.addHeader("Authorization", accessToken);
    //如果刷新成功则存储cookie并且跳转到原来需要访问的页面
    request.getRequestDispatcher(request.getRequestURI()).forward(requestWrapper, response);
  }
}
