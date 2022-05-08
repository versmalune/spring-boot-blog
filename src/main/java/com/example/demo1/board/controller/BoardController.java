package com.example.demo1.board.controller;

import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/board")
    public ModelAndView boardList() throws Exception {
        ModelAndView mv = new ModelAndView("boardList");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return mv;
    }
    @RequestMapping("/board/openBoardWrite")
    public String boardWrite() throws Exception {
        return "/boardWrite";
    }
    @RequestMapping("/board/insertBoard")
    public String insertBoard(@ModelAttribute BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardService.insertBoard(board, multipartHttpServletRequest);
        return "redirect:/board";
    }
    @RequestMapping("/board/openBoardDetail")
    public ModelAndView openBoardDetail(@RequestParam int bidx) throws Exception {
        ModelAndView mv = new ModelAndView("boardDetail");
        BoardDto board = boardService.selectBoardDetail(bidx);
        mv.addObject("board", board);
        return mv;
    }
    @RequestMapping("/board/updateBoard")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }
    @RequestMapping("/board/deleteBoard")
    public String deleteBoard(int bidx) throws Exception {
        boardService.deleteBoard(bidx);
        return "redirect:/board";
    }
}