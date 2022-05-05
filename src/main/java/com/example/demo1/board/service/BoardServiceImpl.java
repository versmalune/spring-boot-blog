package com.example.demo1.board.service;

import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }
    @Override
    public BoardDto selectBoardDetail(int bidx) throws Exception {
        boardMapper.updateHitCount(bidx);
        return boardMapper.selectBoardDetail(bidx);
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
