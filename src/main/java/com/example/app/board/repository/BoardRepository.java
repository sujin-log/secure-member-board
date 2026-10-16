package com.example.app.board.repository;

import com.example.app.board.entity.BoardEntity;
import com.example.app.board.entity.BoardStatus;
import com.example.app.member.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    //status.y 만 조회
    Page<BoardEntity> findByStatus(Pageable pageable, BoardStatus status);

    //memberId로
    Page<BoardEntity> findByMemberAndStatus(Pageable pageable, MemberEntity member, BoardStatus status);

    //제목으로 조회
    Page<BoardEntity> findByTitleAndStatus(Pageable pageable, String title, BoardStatus status);

    //수정하기

    Optional<BoardEntity> findById(Long aLong);
}
