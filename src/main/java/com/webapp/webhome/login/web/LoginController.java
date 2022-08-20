package com.webapp.webhome.login.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.webhome.login.domain.LoginVO;
import com.webapp.webhome.login.service.LoginService;
import com.webapp.webhome.member.domain.SeMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@AllArgsConstructor
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public void login(LoginVO loginVO) throws Exception {

        LoginVO loginUser = loginService.login(loginVO.getId(), loginVO.getPassword());

        if (loginUser.getId() == null){
            System.out.println("Fail");
        }else {
            System.out.println("success!");
        }
    }

}
