package com.webapp.webhome.login.web;

import com.webapp.webhome.login.domain.LoginVO;
import com.webapp.webhome.login.service.LoginService;
import com.webapp.webhome.member.domain.SeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private SeMemberRepository memberRepository;

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(LoginVO loginVO) throws Exception {
        if (loginService.login(loginVO)){
            return "로그인 성공";
        }else {
            return "로그인 실패";
        }
    }

}
