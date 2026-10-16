package com.example.app.board.controller;

import com.example.app.board.dto.request.BoardReqDto;
import com.example.app.board.dto.response.BoardResDto;
import com.example.app.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // 전체 조회
    @GetMapping
    public ResponseEntity<Page<BoardResDto>> boardList(Pageable pageable) {
        return ResponseEntity.ok(
                boardService.boardList(pageable)
        );
    }
    //상세조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardResDto> boardDetail(
            @PathVariable Long id){
        return ResponseEntity.ok(
                boardService.boardDetail(id)
        );

    }


    // 제목으로 조회
    @GetMapping("/title")
    public ResponseEntity<Page<BoardResDto>> titleList(
            Pageable pageable,
            @RequestParam String title) {

        return ResponseEntity.ok(
                boardService.titleList(pageable, title)
        );
    }

    // 게시글 등록
    @PostMapping
    public ResponseEntity<BoardResDto> create(
            @RequestBody BoardReqDto request,
            @RequestParam Long memberNo) {

        // 아직 로그인 기능 전이라 member 연결은 임시 처리 필요
        return ResponseEntity.status(HttpStatus.CREATED).body(
                boardService.create(request, memberNo)
        );
    }

    // 수정
    @PutMapping("/{no}")
    public ResponseEntity<BoardResDto> update(
            @RequestBody BoardReqDto request,
            @PathVariable Long no) {

        return ResponseEntity.ok(
                boardService.update(request, no)
        );
    }

    // 삭제(상태 변경)
    @PutMapping("/delete/{no}")
    public ResponseEntity<BoardResDto> delete(
            @PathVariable Long no) {

        return ResponseEntity.ok(
                boardService.delete(no)
        );
    }
}
