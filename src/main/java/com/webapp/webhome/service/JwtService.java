package com.webapp.webhome.service;

import com.webapp.webhome.domain.TokenVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtManager jwtManager;

    //토큰발급
    public TokenVO createToken(String key){
        String accessToken = jwtManager.generateAccessToken(key);
        String refreshToken = jwtManager.generateRefreshToken(key);
        return new TokenVO(
                accessToken
                , refreshToken
                , jwtManager.getValidationAccessTokenTime()
        );
    }

    //refresh 토큰 갱신
    public TokenVO createTokenByrefreshToken(String refreshToken) {
        String key = jwtManager.getName(refreshToken);
        String accessToken = jwtManager.generateAccessToken(key);
        String refreshTokenNew = jwtManager.generateRefreshToken(key);
        return new TokenVO(
                accessToken
                , refreshTokenNew
                , jwtManager.getValidationAccessTokenTime());
    }

}
