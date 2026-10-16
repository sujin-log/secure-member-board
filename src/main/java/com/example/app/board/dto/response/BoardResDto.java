package com.example.app.board.dto.response;

import com.example.app.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResDto {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createAt;

    public static BoardResDto from(BoardEntity board){
        return BoardResDto.builder()
                .id(board.getId())
                .title(builder().title)
                .content(board.getContent())
                .createAt(board.getCreateAt())
                .build();
    }
}
