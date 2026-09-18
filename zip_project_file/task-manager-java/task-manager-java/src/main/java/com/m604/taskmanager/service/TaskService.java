package com.m604.taskmanager.service;

import com.m604.taskmanager.dto.TaskRequest;
import com.m604.taskmanager.exception.InvalidInputException;
import com.m604.taskmanager.exception.TaskNotFoundException;
import com.m604.taskmanager.model.Task;
import com.m604.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business logic for Task CRUD operations.
 * Includes manual validation + exception throwing → picked up by GlobalExceptionHandler.
 */
@Service
public class TaskService {

    private static final List<String> ALLOWED_STATUS = List.of("pending", "in_progress", "done");
    private static final List<String> ALLOWED_PRIORITY = List.of("low", "medium", "high");

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    // ---------- READ ----------
    @Transactional(readOnly = true)
    public List<Task> getAll(String status) {
        if (status == null || status.isBlank()) {
            return repo.findAll();
        }
        if (!ALLOWED_STATUS.contains(status)) {
            throw new InvalidInputException("invalid status filter: " + status);
        }
        return repo.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    // ---------- CREATE ----------
    @Transactional
    public Task create(TaskRequest req) {
        if (req == null || req.getTitle() == null || req.getTitle().trim().isEmpty()) {
            throw new InvalidInputException("title is required");
        }

        String status = req.getStatus() == null ? "pending" : req.getStatus();
        String priority = req.getPriority() == null ? "medium" : req.getPriority();

        if (!ALLOWED_STATUS.contains(status)) {
            throw new InvalidInputException("status must be pending, in_progress or done");
        }
        if (!ALLOWED_PRIORITY.contains(priority)) {
            throw new InvalidInputException("priority must be low, medium or high");
        }

        Task task = new Task(
                req.getTitle().trim(),
                req.getDescription() == null ? "" : req.getDescription(),
                status,
                priority
        );
        return repo.save(task);
    }

    // ---------- UPDATE ----------
    @Transactional
    public Task update(Long id, TaskRequest req) {
        Task task = getById(id);

        if (req == null) {
            throw new InvalidInputException("no data sent");
        }

        if (req.getTitle() != null) {
            if (req.getTitle().trim().isEmpty()) {
                throw new InvalidInputException("title cannot be empty");
            }
            task.setTitle(req.getTitle().trim());
        }

        if (req.getDescription() != null) {
            task.setDescription(req.getDescription());
        }

        if (req.getStatus() != null) {
            if (!ALLOWED_STATUS.contains(req.getStatus())) {
                throw new InvalidInputException("invalid status");
            }
            task.setStatus(req.getStatus());
        }

        if (req.getPriority() != null) {
            if (!ALLOWED_PRIORITY.contains(req.getPriority())) {
                throw new InvalidInputException("invalid priority");
            }
            task.setPriority(req.getPriority());
        }

        return repo.save(task);
    }

    // ---------- DELETE ----------
    @Transactional
    public void delete(Long id) {
        Task task = getById(id);
        repo.delete(task);
    }
}