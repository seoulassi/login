package com.webapp.webhome.member.service;

import com.webapp.webhome.common.util.EgovFileScrty;
import com.webapp.webhome.common.util.EgovStringUtil;
import com.webapp.webhome.member.domain.SeMember;
import com.webapp.webhome.member.domain.SeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private SeMemberRepository memberRepository;

    /**
     * 회원등록
     * */
    public String memberInsert(MemberVO memberVO) throws Exception {
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

            return "회원등록 성공!";
        }else {
            return "회원 등록 실패! - 아이디 중복";
        }
    }
}
