package com.webapp.webhome.member.service;

import com.webapp.webhome.member.domain.SeMember;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class MemberVO {
    @NotBlank(message = "ID를 확인해주세요.")
    String id;

    @NotBlank(message = "userName을 확인해주세요.")
    String userName;

    @NotBlank(message = "패스워드를 확인해주세요.")
    String password;

    @NotBlank(message = "이름을 확인해주세요.")
    String name;

    // VO > Entity
    public SeMember toEntity(){
        return SeMember.builder()
                .userId(id)
                .userName(userName)
                .password(password)
                .name(name)
                .build();
    }
}
