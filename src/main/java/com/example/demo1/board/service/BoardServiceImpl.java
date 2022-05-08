package com.example.demo1.board.service;

import com.example.demo1.board.common.FileUtils;
import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.dto.BoardFileDto;
import com.example.demo1.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardMapper.insertBoard(board);
        List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBidx(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
    }
    @Override
    public BoardDto selectBoardDetail(int bidx) throws Exception {
        BoardDto board = boardMapper.selectBoardDetail(bidx);
        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(bidx);
        System.out.println(fileList);
        board.setFileList(fileList);
        System.out.println(board);
        boardMapper.updateHitCount(bidx);
        return board;
    }
    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }
    @Override
    public void deleteBoard(int bidx) throws Exception {
        boardMapper.deleteBoard(bidx);
    }
}
