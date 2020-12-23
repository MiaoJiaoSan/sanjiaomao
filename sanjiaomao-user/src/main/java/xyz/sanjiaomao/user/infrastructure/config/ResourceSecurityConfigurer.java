package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@SpringBootConfiguration
public class ResourceSecurityConfigurer extends ResourceServerConfigurerAdapter {

  private ResourceServerProperties resource;

  @Resource
  private DataSource dataSource;

  public ResourceSecurityConfigurer(ResourceServerProperties resource) {
    this.resource = resource;
  }


  @Bean
  public JdbcTokenStore jdbcTokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources)
      throws Exception {
    resources.resourceId(this.resource.getResourceId());
    resources.authenticationEntryPoint(new RefreshTokenAuthenticationEntryPoint());
    resources.tokenStore(jdbcTokenStore());
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated();
  }

  @Autowired
  public void remoteTokenServices(RemoteTokenServices remoteTokenServices, RestTemplate restTemplate) {
    restTemplate.setErrorHandler(new DefaultHandler());
    remoteTokenServices.setRestTemplate(restTemplate);
  }


  public static class DefaultHandler extends DefaultResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
      String statusText = response.getStatusText();
      HttpHeaders headers = response.getHeaders();
      byte[] body = getResponseBody(response);
      Charset charset = getCharset(response);
      String message = getErrorMessage(statusCode.value(), statusText, body, charset);
      if (message.indexOf("Token has expired") != -1) {
        throw new UnauthorizedClientException("Token has expired");
      } else if (message.indexOf("Token was not recognised") != -1) {
        throw new UnauthorizedClientException("Token was not recognised") {
          @Override
          public int getHttpErrorCode() {
            return 403;
          }
        };
      }
      switch (statusCode.series()) {
        case CLIENT_ERROR:
          throw HttpClientErrorException.create(message, statusCode, statusText, headers, body, charset);
        case SERVER_ERROR:
          throw HttpServerErrorException.create(message, statusCode, statusText, headers, body, charset);
        default:
          throw new UnknownHttpStatusCodeException(message, statusCode.value(), statusText, headers, body, charset);
      }
    }

    private String getErrorMessage(
        int rawStatusCode, String statusText, @Nullable byte[] responseBody, @Nullable Charset charset) {

      String preface = rawStatusCode + " " + statusText + ": ";
      if (ObjectUtils.isEmpty(responseBody)) {
        return preface + "[no body]";
      }

      charset = charset == null ? StandardCharsets.UTF_8 : charset;
      int maxChars = 200;

      if (responseBody.length < maxChars * 2) {
        return preface + "[" + new String(responseBody, charset) + "]";
      }

      try {
        Reader reader = new InputStreamReader(new ByteArrayInputStream(responseBody), charset);
        CharBuffer buffer = CharBuffer.allocate(maxChars);
        reader.read(buffer);
        reader.close();
        buffer.flip();
        return preface + "[" + buffer.toString() + "... (" + responseBody.length + " bytes)]";
      } catch (IOException ex) {
        // should never happen
        throw new IllegalStateException(ex);
      }
    }
  }


}
