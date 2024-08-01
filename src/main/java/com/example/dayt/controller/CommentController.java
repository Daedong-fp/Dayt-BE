package com.example.dayt.controller;

import com.example.dayt.dto.Request.CommentRequest;
import com.example.dayt.dto.response.CommentResponse;
import com.example.dayt.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody CommentRequest request) {
        commentService.createComment(request);
    }

    @GetMapping("/{id}")
    public CommentResponse getComment(@PathVariable Long id, @RequestBody CommentRequest request) {
        return commentService.queryComment(id, request);
    }

    @PatchMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest) {
        commentService.updateComment(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }


}
