package com.m604.taskmanager.repository;

import com.m604.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository — CRUD operations are auto-generated.
 * Covers: CRUD support (Project Scope - Backend Development).
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /** Filter tasks by status — used by GET /api/tasks?status=... */
    List<Task> findByStatus(String status);
}