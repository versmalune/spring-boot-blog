package com.example.demo1.board.service;

import com.example.demo1.board.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> commentListService(int bid);
    int insertCommentService(CommentDto comment);
    int updateCommentService(CommentDto comment);
    int deleteCommentService(int id);
}
