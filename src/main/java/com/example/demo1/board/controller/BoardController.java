package com.example.demo1.board.controller;

import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public ModelAndView boardList() throws Exception {
        ModelAndView mv = new ModelAndView("boardList");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return mv;
    }
    @GetMapping("/openBoardWrite")
    public String boardWrite() throws Exception {
        return "/boardWrite";
    }
    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardService.insertBoard(board, multipartHttpServletRequest);
        return "redirect:/board";
    }
    @GetMapping("/openBoardDetail")
    public ModelAndView openBoardDetail(@RequestParam int id) throws Exception {
        ModelAndView mv = new ModelAndView("boardDetail");
        BoardDto board = boardService.selectBoardDetail(id);
        mv.addObject("board", board);
        return mv;
    }
    @PostMapping("/updateBoard")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }
    @GetMapping("/deleteBoard")
    public String deleteBoard(int id) throws Exception {
        boardService.deleteBoard(id);
        return "redirect:/board";
    }
}