package com.webapp.webhome.member.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.Principal;

public interface SeMemberRepository extends JpaRepository<SeMember, Long> {
    // 로그인
    SeMember findByUserIdAndPasswordAndDelFlag(String userId, String password, String delFlag);

    // 아이디 중복 체크
    SeMember findByUserIdAndDelFlag(String userId, String delFlag);

    // 활성 회원 리스트 페이징
    //Page<SeMember> findByDelFlag(String delFlag, Pageable pageable);
    @Query(value="SELECT sm.userId as id, sm.userName as username, sm.name as name from SeMember sm where sm.delFlag = '1'")
    Page<SeMember> findAllPage(Pageable pageable);

}
