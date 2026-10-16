package com.example.app.member.controller;

import com.example.app.member.dto.request.JoinReqDto;
import com.example.app.member.dto.request.LoginReqDto;
import com.example.app.member.dto.response.MemberResDto;
import com.example.app.member.entity.MemberEntity;
import com.example.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    //조회하기
    @GetMapping("/list")
    public ResponseEntity<Page<MemberResDto>> memberList(Pageable pageable) {
        return ResponseEntity.ok(
                memberService.memberList(pageable)
        );
    }
    //회원가입
    @PostMapping
    public ResponseEntity<MemberResDto> create(
            @RequestBody JoinReqDto join){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.join(join));
    }
    //로그인
    @PostMapping("login")
    public ResponseEntity<MemberResDto> login(
            @RequestBody LoginReqDto login

    ){
        return ResponseEntity.ok(
                memberService.login(login)
        );
    }

    //수정하기
    @PutMapping("/{no}")
    private ResponseEntity<MemberResDto> update(
            @PathVariable long no,
            @RequestBody JoinReqDto join
    ){
        return ResponseEntity.ok(
                memberService.update(no,join)
        );

    }
    // 아이디로 조회 (단건 조회)
    @GetMapping("/list/{memberId}")
    public ResponseEntity<MemberResDto> memberIdList(@PathVariable String memberId) {
        return ResponseEntity.ok(
                memberService.memberIdList(memberId)
        );
    }

    //삭제하기
    @PutMapping("/delete/{no}")

    private ResponseEntity<MemberResDto> delete(
            @PathVariable Long no
    ){
        return ResponseEntity.ok(
                memberService.delete(no)
        );
    }


}
