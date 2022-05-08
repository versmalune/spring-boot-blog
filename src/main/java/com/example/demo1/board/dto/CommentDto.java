package com.example.demo1.board.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int cidx;
    private int bidx;
    private String comcontent;
    private String comwriter;
}
