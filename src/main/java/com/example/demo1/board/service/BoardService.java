package com.example.demo1.board.service;

import com.example.demo1.board.dto.BoardDto;
import java.util.List;


public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
    BoardDto selectBoardDetail(int bidx) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int bidx) throws Exception;
}
