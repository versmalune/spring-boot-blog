package com.example.demo1.board.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int fidx;
    private int bidx;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}
