package com.webapp.webhome.member.web;

import com.webapp.webhome.common.util.EgovFileScrty;
import com.webapp.webhome.common.util.EgovStringUtil;
import com.webapp.webhome.member.service.MemberVO;
import com.webapp.webhome.member.domain.SeMember;
import com.webapp.webhome.member.domain.SeMemberRepository;
import com.webapp.webhome.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MemberController {
    @Autowired
    private SeMemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @GetMapping("/test")
    public void test(){
        List<SeMember> memberLists = memberRepository.findAll();

        System.out.println(memberLists.size());
    }


    /**
     * 회원 등록
     * */
    @PostMapping("/memberJoin")
    public String memberInsert(MemberVO memberVO) throws Exception {
        String result = memberService.memberInsert(memberVO);

        return result;
    }

    /**
     * 회원 리스트
     * */
    @GetMapping("/memberList")
    Page<SeMember> memberList(Pageable pageable){
        return memberRepository.findAllPage(pageable);
    }




}
