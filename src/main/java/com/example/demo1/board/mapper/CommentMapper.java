package com.example.demo1.board.mapper;

import com.example.demo1.board.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("com.example.demo1.board.mapper.CommentMapper")
public interface CommentMapper {
    List<CommentDto> commentList(int id) throws Exception;
    int commentInsert(CommentDto comment) throws Exception;
    int commentUpdate(CommentDto comment) throws Exception;
    int commentDelete(int id) throws Exception;
}