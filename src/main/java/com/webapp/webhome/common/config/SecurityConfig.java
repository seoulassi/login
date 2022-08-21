package com.webapp.webhome.common.config;

import com.webapp.webhome.service.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtManager jwtManager;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()// rest api이므로 csrf 보안이 필요없으므로 비활성화
                .httpBasic().disable() // rest api 이므로 로그인폼으로 이동 비활성화
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션필요없음
                .and()
                .authorizeRequests().antMatchers(whitelistedUriPatterns()).permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtManager) // jwt 로 접근허용 필터 생성
                        , UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()  // exception이 날 경우 catch하여 result form 일관하게 만듬(필요없음 제거)
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;
    }


    private String[] whitelistedUriPatterns() {
        return new String[]{
                "/login",
                "/logout",
                "/api/**"
        };
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                // -- Static resources
                "/css/**", "/images/**", "/js/**"
                // -- Swagger UI v2
                , "/v2/api-docs", "/swagger-resources/**"
                , "/swagger-ui.html", "/webjars/**", "/swagger/**"
                // -- Swagger UI v3 (Open API)
                , "/v3/api-docs/**", "/swagger-ui/**"
        );
    }
}