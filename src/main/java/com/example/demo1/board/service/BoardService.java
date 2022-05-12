package com.example.demo1.board.service;

import com.example.demo1.board.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.List;


public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    BoardDto selectBoardDetail(int id) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int id) throws Exception;
}
