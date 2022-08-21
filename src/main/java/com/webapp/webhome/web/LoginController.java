package com.webapp.webhome.web;

import com.webapp.webhome.common.response.Message;
import com.webapp.webhome.common.response.StatusEnum;
import com.webapp.webhome.domain.LoginVO;
import com.webapp.webhome.domain.SeMember;
import com.webapp.webhome.domain.SeMemberRepository;
import com.webapp.webhome.domain.TokenVO;
import com.webapp.webhome.service.JwtService;
import com.webapp.webhome.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@Slf4j
@RestController
@AllArgsConstructor
public class LoginController {

    private final String secretKey = "secretKey-test-authorization-jwt-manage-token";

    private SeMemberRepository memberRepository;
    private LoginService loginService;

    private JwtService jwtService;

    /**
     * 로그인
     * */
    @ApiOperation(value = "로그인/토큰발급", notes = "")
    @PostMapping("/login")
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

            TokenVO loginToken = jwtService.createToken(id);

            String accessToken = loginToken.getAccessToken();
            String refreshToken = loginToken.getRefreshToken();

            System.out.println(accessToken);
            System.out.println(refreshToken);

            message.setData(loginToken);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    /**
     * 로그인 회원 정보
     * */
    @GetMapping("/userInfo")
    public ResponseEntity<Message> memberInfo(Principal principal){
        String userId = principal.getName();
        Message message = new Message();
        SeMember user = memberRepository.findByUserIdAndDelFlag(userId,"1");

        message.setStatus(StatusEnum.OK);
        message.setMessage("인증 성공");
        message.setData(user);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
