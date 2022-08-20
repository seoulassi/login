package com.webapp.webhome.login.domain;

import com.webapp.webhome.member.domain.SeMember;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
    private String id;
    private String password;
}
