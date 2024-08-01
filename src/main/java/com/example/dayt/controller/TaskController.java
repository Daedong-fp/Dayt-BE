package com.example.dayt.controller;

import com.example.dayt.dto.Request.TaskRequest;
import com.example.dayt.dto.response.TaskResponse;
import com.example.dayt.entity.Task;
import com.example.dayt.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public void createTask(@RequestBody TaskRequest request) {
        taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponse> getAllTask() {
        return taskService.getAllTask();
    }

    @PatchMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
