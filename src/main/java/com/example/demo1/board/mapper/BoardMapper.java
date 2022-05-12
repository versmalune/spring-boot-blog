package com.example.demo1.board.mapper;

import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
    void updateHitCount(int id) throws Exception;
    BoardDto selectBoardDetail(int id) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int id) throws Exception;
    void insertBoardFileList(List<BoardFileDto> list) throws Exception;
    List<BoardFileDto> selectBoardFileList(int id) throws Exception;
}