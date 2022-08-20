package com.webapp.webhome.login.service;

import com.webapp.webhome.common.util.EgovFileScrty;
import com.webapp.webhome.common.util.EgovStringUtil;
import com.webapp.webhome.login.domain.LoginVO;
import com.webapp.webhome.member.domain.SeMember;
import com.webapp.webhome.member.domain.SeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private SeMemberRepository memberRepository;

    /**
     * 로그인 체크
     * */
    public LoginVO login(String userid, String password) throws Exception {
        LoginVO loginVO = new LoginVO();
        // 패스워드 암호화
        String pass = EgovFileScrty.encryptPassword(password, EgovStringUtil.isNullToString(userid));

        // 아이디, 패스워드, 활성회원(1) 만 조회.
        SeMember login = memberRepository.findByUserIdAndPasswordAndDelFlag(userid,pass,"1");

        if (login != null){
            loginVO.setId(login.getUserId());
        }
        return loginVO;
    }
}
