package com.example.app.board.service;

import com.example.app.board.dto.request.BoardReqDto;
import com.example.app.board.dto.response.BoardResDto;
import com.example.app.board.entity.BoardEntity;
import com.example.app.board.entity.BoardStatus;
import com.example.app.board.repository.BoardRepository;
import com.example.app.member.entity.MemberEntity;
import com.example.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    //조회하기
    public Page<BoardResDto> boardList(Pageable pageable){
        return boardRepository.findByStatus(pageable, BoardStatus.Y)
                .map(BoardResDto::from);

    }
    //상세조회하기
    public BoardResDto boardDetail(Long id) {
        BoardEntity board =  boardRepository.findById(id)
                .orElseThrow(()->new RuntimeException("게사글이 없습니다."));

        return BoardResDto.from(board);
    }

    //memberId로 조회
    public Page<BoardResDto> memberIdList(Pageable pageable, MemberEntity member){
        return boardRepository.findByMemberAndStatus(pageable, member, BoardStatus.Y)
                .map(BoardResDto::from);
    }

    //제목으로 조회
    public Page<BoardResDto> titleList(Pageable pageable, String title){
        return boardRepository.findByTitleAndStatus(pageable, title, BoardStatus.Y)
                .map(BoardResDto::from);
    }

    //등록하기
    public BoardResDto create(BoardReqDto request, Long no){

        MemberEntity member = memberRepository.findById(no)
                .orElseThrow(() -> new RuntimeException("회원정보가 없습니다."));

        BoardEntity board = request.toBoard(member);

        BoardEntity saveBoard = boardRepository.save(board);

        return BoardResDto.from(saveBoard);
    }

    //수정하기
    public BoardResDto update(BoardReqDto request, Long no){
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(()->new RuntimeException("해당게시글이 없습니다.")
                );
        board.update(request);
        return BoardResDto.from(board);

    }

    //삭제하기
    public BoardResDto delete(Long no){
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(()->new RuntimeException("해당게시글이 없습니다.")
                );
        board.delete();
        return BoardResDto.from(board);

    }
}
