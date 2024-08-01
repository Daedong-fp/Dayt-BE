package com.example.dayt.service;

import com.example.dayt.dto.Request.CommentRequest;
import com.example.dayt.dto.response.CommentResponse;
import com.example.dayt.entity.Comment;
import com.example.dayt.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@DynamicUpdate
public class CommentService {
    private final CommentRepository commentRepository;

    private static final int MaxComment = 9;

    public void createComment(CommentRequest request) {

        Comment comment = Comment.builder()
                .id(request.getId())
                .requirement(request.getRequirement())
                .content(request.getContent())
                .userName(request.getUserName())
                .createTime(request.getCreateTime())
                .build();
        commentRepository.save(comment);
    }

    //전체 조회
    public List<CommentResponse> getAllComment() {
        List<Comment> comments = commentRepository.findAll();

        return comments.stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void updateComment(Long id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        comment.update(commentRequest);
    }

    public void deleteComment(Long RequirementId) {
        commentRepository.deleteById(RequirementId);
    }

}
