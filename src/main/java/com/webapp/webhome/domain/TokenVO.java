package com.webapp.webhome.domain;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class TokenVO {
    @NonNull
    private String accessToken;

    @NonNull
    private String refreshToken;

    @NonNull
    private Long expireSec;

    public TokenVO(@NonNull String accessToken, @NonNull String refreshToken, @NonNull Long expireSec){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireSec = expireSec;
    }
}
