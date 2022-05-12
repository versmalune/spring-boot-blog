package com.example.demo1.board.service;

import com.example.demo1.board.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> commentListService(int bid) throws Exception;
    int insertCommentService(CommentDto comment) throws Exception;
    int updateCommentService(CommentDto comment) throws Exception;
    int deleteCommentService(int id) throws Exception;
}
