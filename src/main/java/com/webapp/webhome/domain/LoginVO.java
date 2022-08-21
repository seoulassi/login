package com.webapp.webhome.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LoginVO {
    private String id;
    private String password;
    private List<String> roles = new ArrayList<>();

    public LoginVO(){
        roles.add("ROLE_USER");
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
