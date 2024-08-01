package com.example.dayt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Requirement")
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id",nullable = false)
    private Board board;

    private Long userId;

    private String title;

    private String content;

    private int createTime;


    @Builder
    public Requirement(Long id, Board board, Long userId, String title, String content, int createTime) {
        this.id = id;
        this.board = board;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
