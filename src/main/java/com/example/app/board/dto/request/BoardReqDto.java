package com.example.app.board.dto.request;

import com.example.app.board.entity.BoardEntity;
import com.example.app.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardReqDto {

    private String title;

    private String content;

    public BoardEntity toBoard(MemberEntity member){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .build();
    }
}
