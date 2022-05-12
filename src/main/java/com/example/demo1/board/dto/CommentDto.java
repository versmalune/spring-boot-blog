package com.example.demo1.board.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int id;
    private int bid;
    private String comcontent;
    private String comwriter;
}
