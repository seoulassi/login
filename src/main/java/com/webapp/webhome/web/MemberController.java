package com.webapp.webhome.web;

import com.webapp.webhome.common.response.Message;
import com.webapp.webhome.common.response.StatusEnum;
import com.webapp.webhome.domain.SeMember;
import com.webapp.webhome.domain.SeMemberRepository;
import com.webapp.webhome.service.MemberService;
import com.webapp.webhome.service.MemberVO;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private SeMemberRepository memberRepository;

    private MemberService memberService;

    /**
     * 회원 등록
     * */
    @ApiOperation(value = "회원 등록", notes = "")
    @PostMapping("/memberJoin")
    public ResponseEntity<Message> memberInsert(MemberVO memberVO) throws Exception {
        Message message = new Message();

        if (!memberService.memberInsert(memberVO)){
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("회원등록 실패");

        }else {
            message.setStatus(StatusEnum.OK);
            message.setMessage("회원등록 성공");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * 회원 리스트
     * */
    @ApiOperation(value = "회원 리스트", notes = "")
    @GetMapping("/memberList")
    Page<SeMember> memberList(Pageable pageable){
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        return memberRepository.findAllPage(pageable);
    }

}
