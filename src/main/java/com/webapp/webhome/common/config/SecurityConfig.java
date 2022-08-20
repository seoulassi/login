package com.webapp.webhome.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/oauth/authorize").permitAll()
                .antMatchers("/oauth/**").permitAll()
            .and()
                .formLogin()
            .and()
                .httpBasic()
        ;
    }
}