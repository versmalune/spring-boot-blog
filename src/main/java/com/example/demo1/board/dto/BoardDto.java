package com.example.demo1.board.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int bidx;
    private String title;
    private String content;
    private String writer;
    private int viewcnt;
}
