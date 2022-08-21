package com.webapp.webhome.common.config;

import com.webapp.webhome.service.JwtManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${Globals.jwt.secretKey}")
    String secretKey;

    @Bean
    public JwtManager jwtManager() {
        int accessTokenExpireSecond  = 60 * 30; // 30분
        int refreshTokenExpireSecond  = 60 * 60 * 24 * 30; // 1개월

        return new JwtManager(secretKey, Long.valueOf(accessTokenExpireSecond), Long.valueOf(refreshTokenExpireSecond));
    }

}
