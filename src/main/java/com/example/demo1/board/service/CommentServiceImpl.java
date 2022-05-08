package com.example.demo1.board.service;

import com.example.demo1.board.dto.CommentDto;
import com.example.demo1.board.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentDto> commentListService(int bidx) throws Exception {
        return commentMapper.commentList(bidx);
    }
    @Override
    public int insertCommentService(CommentDto comment) throws Exception {
        return commentMapper.commentInsert(comment);
    }
    @Override
    public int updateCommentService(CommentDto comment) throws Exception {
        return commentMapper.commentUpdate(comment);
    }
    @Override
    public int deleteCommentService(int cidx) throws Exception {
        return commentMapper.commentDelete(cidx);
    }
}