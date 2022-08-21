package com.webapp.webhome.service;

import com.webapp.webhome.common.util.EgovFileScrty;
import com.webapp.webhome.common.util.EgovStringUtil;
import com.webapp.webhome.domain.SeMember;
import com.webapp.webhome.domain.SeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private SeMemberRepository memberRepository;

    /**
     * 회원등록
     * */
    public boolean memberInsert(MemberVO memberVO) throws Exception {
        // 아이디 중복 체크
        SeMember memberck = memberRepository.findByUserIdAndDelFlag(memberVO.getId(), "1");

        if (memberck ==null){
            // 비밀번호 암호화
            String pass = EgovFileScrty.encryptPassword(memberVO.getPassword(), EgovStringUtil.isNullToString(memberVO.getId()));
            memberVO.setPassword(pass);

            // Entity 변환
            SeMember member = memberVO.toEntity();

            // 회원 등록
            memberRepository.save(member);

            return true;
        }else {
            return false;
        }
    }
}
