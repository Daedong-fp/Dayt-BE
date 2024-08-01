package com.example.dayt.dto.Request;

import com.example.dayt.entity.Board;
import lombok.Getter;

@Getter
public class TaskRequest {
    private Long id;
    private Board board;
    private String userName;
    private String title;
    private String takeList;
    private String status;
    private int createTime;
}
