package com.example.dayt.repository;

import com.example.dayt.entity.Board;
import
        com.example.dayt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT COUNT(t) FROM Task t WHERE t.board = :board")
    long countByBoard(@Param("board") Board board);
}
