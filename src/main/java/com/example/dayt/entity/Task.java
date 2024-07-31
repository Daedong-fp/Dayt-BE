package com.example.dayt.entity;

import com.example.dayt.dto.TaskRequest;
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

    @Column(columnDefinition = "varchar (20) default 'empty'")
    private String title;

    @Column(columnDefinition = "varchar (30) default 'empty'")
    private String takeList;

    private int createTime;
    private String status;

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

