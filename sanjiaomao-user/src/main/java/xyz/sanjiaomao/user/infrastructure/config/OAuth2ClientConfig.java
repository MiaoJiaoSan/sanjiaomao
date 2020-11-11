package xyz.sanjiaomao.user.infrastructure.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/*
  鉴权过滤器
* @  OAuth2AuthenticationProcessingFilter
*
* */
@EnableOAuth2Client
@EnableConfigurationProperties
@Configuration
public class OAuth2ClientConfig {


    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    public PrincipalExtractor principalExtractor(){

        return new PrincipalExtractor() {

            private final String[] PRINCIPAL_KEYS = new String[] { "principal"};

            @Override
            public Object extractPrincipal(Map<String, Object> map) {
                for (String key : PRINCIPAL_KEYS) {
                    if (map.containsKey(key)) {
                        return map.get(key);
                    }
                }
                return null;
            }
        };
    }
}
