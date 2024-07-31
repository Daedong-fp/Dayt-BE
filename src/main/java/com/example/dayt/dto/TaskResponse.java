package com.example.dayt.dto;

import com.example.dayt.entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskResponse {
    private Board board;
    private String title;
    private String takeList;
    private String userName;
    private String status;
    private int createTime;

    @Builder
    public TaskResponse(Board board, String title, String takeList, String userName, String status, int createTime) {
        this.board = board;
        this.title = title;
        this.takeList = takeList;
        this.userName = userName;
        this.status = status;
        this.createTime = createTime;
    }
}
