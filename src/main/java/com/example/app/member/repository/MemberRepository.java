package com.example.app.member.repository;

import com.example.app.member.entity.MemberEntity;
import com.example.app.member.entity.MemberStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


    //탈퇴하지않은 회원만 조회
    Page<MemberEntity> findByStatus(
            MemberStatus memberStatus,
            Pageable pageable);

    //로그인하기
    //로그인하기
    Optional<MemberEntity> findByMemberIdAndMemberPw(String memberId, String memberPw);

    //아이디로 조회
    Optional<MemberEntity> findByMemberId(String memberId);

}
