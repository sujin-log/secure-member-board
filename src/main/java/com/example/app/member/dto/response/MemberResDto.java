package com.example.app.member.dto.response;

import com.example.app.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberResDto {
    private Long No;
    private String memberId;
    private String memberPw;
    private String nickName;
    private LocalDateTime createAt;

    public static MemberResDto from(MemberEntity member){
        return MemberResDto.builder()
                .No(member.getNo())
                .memberId(member.getMemberId())
                .memberPw(member.getMemberPw())
                .nickName(member.getNickName())
                .createAt(member.getCreateAt())
                .build();
    }
}
