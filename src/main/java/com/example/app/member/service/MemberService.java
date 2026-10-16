package com.example.app.member.service;

import com.example.app.member.dto.request.JoinReqDto;
import com.example.app.member.dto.request.LoginReqDto;
import com.example.app.member.dto.response.MemberResDto;
import com.example.app.member.entity.MemberEntity;
import com.example.app.member.entity.MemberStatus;
import com.example.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //조회하기
    public Page<MemberResDto> memberList(Pageable pageable){
        return memberRepository.findByStatus(MemberStatus.ACTIVE, pageable)
                .map(MemberResDto::from);
    }
    //로그인하기
    public MemberResDto login(LoginReqDto login){
        MemberEntity member = memberRepository.findByMemberIdAndMemberPw(login.getMemberId(), login.getMemberPw())
                .orElseThrow(()->new RuntimeException("회원정보가 없음"));
        if (member.getStatus() != MemberStatus.ACTIVE){
            throw new RuntimeException("비활성화된 계정입니다.");
        }
        return MemberResDto.from(member);
    }

    //회원가입하기
    public MemberResDto join(JoinReqDto request){
        MemberEntity member = request.toMemberJoin();
        MemberEntity saveMember = memberRepository.save(member);

        return MemberResDto.from(saveMember);
    }
    //아이디로 조회(단건 조회)
    public MemberResDto memberIdList(String memberId) {
        MemberEntity member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return MemberResDto.from(member); // 기존 DTO 변환 방식에 맞추세요
    }

    //수정하기
    public MemberResDto update(Long no, JoinReqDto join ){
        MemberEntity member = memberRepository.findById(no)
                .orElseThrow(()->new RuntimeException("회원정보가 없습니다."));

        member.update(join);
        return MemberResDto.from(member);
    }

    //삭제하기 회원상태 변경
    public MemberResDto delete(Long no){
        MemberEntity member = memberRepository.findById(no)
                .orElseThrow(()->new RuntimeException("회원정보가 없습니다."));

        member.delete();
        return MemberResDto.from(member);

    }
}