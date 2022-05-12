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
    public List<CommentDto> commentList(@RequestParam int bidx) throws Exception {
        return commentService.commentListService(bidx);
    }
    @RequestMapping("/insert")
    @ResponseBody
    public int commentInsert(@RequestParam int bidx, @RequestParam String comcontent) throws Exception {
        CommentDto comment = new CommentDto();
        comment.setBid(bidx);
        comment.setComcontent(comcontent);
        comment.setComwriter("testuser");
        return commentService.insertCommentService(comment);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int commentUpdate(@RequestParam int cidx, @RequestParam String comcontent) throws Exception {
        CommentDto comment = new CommentDto();
        comment.setId(cidx);
        comment.setComcontent(comcontent);
        return commentService.updateCommentService(comment);
    }
    @RequestMapping("/delete/{cidx}")
    @ResponseBody
    private int commentDelete(@PathVariable int cidx) throws Exception{
        return commentService.deleteCommentService(cidx);
    }
}