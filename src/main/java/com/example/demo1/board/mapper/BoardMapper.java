package com.example.demo1.board.mapper;

import com.example.demo1.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
    void updateHitCount(int bidx) throws Exception;
    BoardDto selectBoardDetail(int bidx) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int bidx) throws Exception;
}