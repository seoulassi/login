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
    public boolean login(LoginVO loginVO) throws Exception {
        // 패스워드 암호화
        String pass = EgovFileScrty.encryptPassword(loginVO.getPassword(), EgovStringUtil.isNullToString(loginVO.getId()));

        // 아이디, 패스워드, 활성회원(1) 만 조회.
        SeMember login = memberRepository.findByUserIdAndPasswordAndDelFlag(loginVO.getId(),pass,"1");

        if (login == null){
            // 로그인 실패
            return false;
        }
        return true;
    }
}
