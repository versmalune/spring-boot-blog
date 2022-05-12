package com.example.demo1.board.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int id;
    private int bid;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}
