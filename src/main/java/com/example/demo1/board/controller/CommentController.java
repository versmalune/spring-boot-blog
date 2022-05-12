package com.example.demo1.board.controller;

import com.example.demo1.board.dto.CommentDto;
import com.example.demo1.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list")
    @ResponseBody
    public List<CommentDto> commentList(@RequestParam int id) throws Exception {
        return commentService.commentListService(id);
    }
    @RequestMapping("/insert")
    @ResponseBody
    public int commentInsert(@RequestParam int bid, @RequestParam String comcontent) throws Exception {
        CommentDto comment = new CommentDto();
        comment.setBid(bid);
        comment.setComcontent(comcontent);
        comment.setComwriter("testuser");
        return commentService.insertCommentService(comment);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int commentUpdate(@RequestParam int id, @RequestParam String comcontent) throws Exception {
        CommentDto comment = new CommentDto();
        comment.setId(id);
        comment.setComcontent(comcontent);
        return commentService.updateCommentService(comment);
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    private int commentDelete(@PathVariable int id) throws Exception{
        return commentService.deleteCommentService(id);
    }
}