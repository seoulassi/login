package com.webapp.webhome.login.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.webhome.common.response.Message;
import com.webapp.webhome.common.response.StatusEnum;
import com.webapp.webhome.login.domain.LoginVO;
import com.webapp.webhome.login.service.LoginService;
import com.webapp.webhome.member.domain.SeMember;
import com.webapp.webhome.member.domain.SeMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@RestController
@AllArgsConstructor
public class LoginController {

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    private SeMemberRepository memberRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private OauthAuthenticationProvider provider;

    @PostMapping("/api/login")
    public ResponseEntity<Message> login(String id, String password) throws Exception {
        Message message = new Message();

        LoginVO loginUser = loginService.login(id, password);

        if (loginUser.getId() == null){
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("로그인 실패");

            return new ResponseEntity<>(message, HttpStatus.OK);
        }else {
            // 로그인 성공 메세지.
            message.setStatus(StatusEnum.OK);
            message.setMessage("로그인 성공");

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
    @GetMapping("/api/logout")
    public void logut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            System.out.println("로그아웃!");
        }
    }

    @GetMapping("/me")
    SeMember memberInfo(Principal principal){
        String userId = (String) principal.getName();
        return memberRepository.findByUserIdAndDelFlag(userId,"1");
    }
//    public String apiMe(Principal principal) {
//        System.out.println("principal = " + principal);
//
//        if(principal == null) {
//            return "pricipal is null";
//        }
//        return principal.getName();
//    }

}
