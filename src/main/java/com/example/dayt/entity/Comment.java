package com.example.dayt.entity;

import com.example.dayt.dto.Request.CommentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Requirement requirement;

    private String userName;

    @Column(length = 100)
    private String content;

    private int createTime;

    @Builder
    public Comment(Long id, Requirement requirement, String userName, String content, int createTime) {
        this.id = id;
        this.requirement = requirement;
        this.content = content;
        this.userName = userName;
        this.createTime = createTime;
    }

    public void update(CommentRequest commentRequest) {
        this.content = content;
    }
}
