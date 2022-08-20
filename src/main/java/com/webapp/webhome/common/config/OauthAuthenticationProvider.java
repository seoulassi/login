package com.webapp.webhome.common.config;

import com.webapp.webhome.login.domain.LoginVO;
import com.webapp.webhome.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
@RequiredArgsConstructor
public class OauthAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private LoginService loginService;

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
//        System.out.println("authentication.username = " + username);
//        System.out.println("authentication.password = " + password);

        LoginVO loginUser = loginService.login(username, password);

        if (loginUser.getId() == null){
            throw new BadCredentialsException(username);
        }

        return new UsernamePasswordAuthenticationToken(username, password, loginUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
