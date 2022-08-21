package com.webapp.webhome.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@DynamicInsert
@DynamicUpdate
public class SeMember {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "MEMBER_SEQ")
    private Long userCno; // 키값. 시퀀스

    @Column
    private String userId; //회원 아이디

    @Column
    private String userName; // userName

    @Column
    @JsonIgnore
    private String password; // 비밀번호

    @Column
    private String name; // 이름

    @Column
    private LocalDateTime createDate; // 생성시간

    @Column
    @JsonIgnore
    private String delFlag; // 0삭제 1활성

    @Builder
    public SeMember(String userId, String userName, String password, String name){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
