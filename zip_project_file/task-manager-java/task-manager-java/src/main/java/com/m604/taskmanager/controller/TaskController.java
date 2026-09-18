package com.m604.taskmanager.controller;

import com.m604.taskmanager.dto.TaskRequest;
import com.m604.taskmanager.model.Task;
import com.m604.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST API endpoints — mirror of the Flask routes.
 *   GET    /api                  → API info
 *   GET    /api/tasks            → list (optional ?status=)
 *   GET    /api/tasks/{id}       → single
 *   POST   /api/tasks            → create
 *   PUT    /api/tasks/{id}       → update
 *   DELETE /api/tasks/{id}       → delete
 */
@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> apiInfo() {
        return Map.of(
                "message", "Task Manager API is running",
                "endpoints", List.of(
                        "GET /api/tasks",
                        "GET /api/tasks/{id}",
                        "POST /api/tasks",
                        "PUT /api/tasks/{id}",
                        "DELETE /api/tasks/{id}"
                )
        );
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(@RequestParam(required = false) String status) {
        return service.getAll(status);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest req) {
        Task created = service.create(req);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/tasks/{id}")
    public Map<String, String> deleteTask(@PathVariable Long id) {
        service.delete(id);
        return Map.of("message", "task deleted");
    }
}