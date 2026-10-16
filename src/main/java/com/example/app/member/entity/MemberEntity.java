package com.example.app.member.entity;

import com.example.app.member.dto.request.JoinReqDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder

public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long no;

    @Column
    private String memberId;

    @Column
    private String memberPw;

    @Column
    private String nickName;

    @Column
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private MemberStatus status = MemberStatus.ACTIVE;

    //수정하기
    public void update(JoinReqDto join){
        this.memberId = join.getMemberId();
        this.memberPw = join.getMemberPw();
        this.nickName = join.getNickName();
    }
    public void delete(){
        this.status = MemberStatus.DISABLED;
    }
}
