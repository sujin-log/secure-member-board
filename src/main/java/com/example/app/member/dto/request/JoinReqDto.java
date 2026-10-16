package com.example.app.member.dto.request;

import com.example.app.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinReqDto {

    private String memberId;
    private String memberPw;
    private String nickName;

    public MemberEntity toMemberJoin(){
        return MemberEntity.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .nickName(nickName)
                .build();
    }
}
