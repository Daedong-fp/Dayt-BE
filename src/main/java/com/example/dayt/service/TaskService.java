package com.example.dayt.service;

import com.example.dayt.dto.Request.TaskRequest;
import com.example.dayt.dto.response.TaskResponse;
import com.example.dayt.entity.Board;
import com.example.dayt.entity.Task;
import com.example.dayt.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@DynamicUpdate
public class TaskService {

    private static final int MaxTask = 8;

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void createTask(TaskRequest request) {
        Board board = request.getBoard();

        long taskCountBoard = taskRepository.countByBoard(board);

        if (taskCountBoard >= MaxTask) {
            try {
                throw new IllegalAccessException("작업물 생성 한도 초과");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        taskRepository.save(
                Task.builder()
                        .id(request.getId())
                        .board(request.getBoard())
                        .userName(request.getUserName())
                        .title(request.getTitle())
                        .takeList(request.getTakeList())
                        .createTime(request.getCreateTime())
                        .build());
    }


    @Transactional
    public void moveTask(Long id, Board targetBoard) throws IllegalAccessException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task Not Found"));

        long taskCount = taskRepository.countByBoard(targetBoard);

        if (taskCount >= MaxTask) {
            throw new IllegalAccessException("작업물 한도 초과");
        }

        task.move(targetBoard);

        taskRepository.save(task);
    }

    //전체 조회
    public List<TaskResponse> getAllTask() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        task.update(request);
        taskRepository.save(task);
    }

}
