package com.example.app.board.entity;

import com.example.app.board.dto.request.BoardReqDto;
import com.example.app.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


    @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();


    // 기본은 y
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column
    private BoardStatus status = BoardStatus.Y;


    // 외래키 연결
    //여러 Board가 하나의 Member를 가질 수 있다
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private MemberEntity member;

    //수정하기
    public void update(BoardReqDto request){
        this.title = request.getTitle();
        this.content = request.getContent();

    }
    //삭제하기
    public void delete(){
        this.status = BoardStatus.N;
    }
}


