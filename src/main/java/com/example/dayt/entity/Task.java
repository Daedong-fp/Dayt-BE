package com.example.dayt.entity;

import com.example.dayt.dto.Request.TaskRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    private String userName;

    @Column(length = 20)
    private String title;

    @Column(length = 30)
    private String takeList;


    @Column(length = 10)
    private String status;

    private int createTime;

    @Builder
    public Task(Long id, Board board, String userName, String title, String takeList, String status, int createTime) {
        this.id = id;
        this.board = board;
        this.userName = userName;
        this.title = title;
        this.takeList = takeList;
        this.status = status;
        this.createTime = createTime;
    }

    public void update(TaskRequest taskRequest) {
        this.title = taskRequest.getTitle();
        this.takeList = taskRequest.getTakeList();
        this.status = taskRequest.getStatus();
    }

    public void move(Board targetBoard) {
        this.board = targetBoard;
    }
}

