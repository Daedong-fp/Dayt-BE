package com.example.dayt.dto.response;

import com.example.dayt.entity.Comment;
import com.example.dayt.entity.Requirement;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentResponse {
    private Requirement requirement;
    private String userName;
    private String content;
    private int createTime;

    @Builder
    public CommentResponse(Requirement requirement, String userName, String content, int createTime) {
        this.requirement = requirement;
        this.userName = userName;
        this.content = content;
        this.createTime = createTime;
    }

    public CommentResponse(Comment comment) {
        this.content = comment.getContent();
        this.userName = comment.getUserName();
        this.requirement = comment.getRequirement();
        this.createTime = comment.getCreateTime();
    }



}
