package com.example.app.member.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqDto {

    private String memberId;

    private String memberPw;
}
