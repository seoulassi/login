package com.webapp.webhome.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
                .withClient("webapp") // 클라이언트 아이디
                .secret("webapp_se") // 클라이언트 시크릿
                .redirectUris("http://localhost:6066/oauth2/callback")
                .authorizedGrantTypes("authorization_code","password","refresh_token")
                .authorities("ROLE_USER")
                .scopes("read","write")
                .accessTokenValiditySeconds(60 * 30)            // access token 유효 기간 (초 단위)
                .refreshTokenValiditySeconds(60 * 60 * 24 * 120);   // refresh token 유효 기간 (초 단위)
    }
}
