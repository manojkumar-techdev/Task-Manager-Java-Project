package com.m604.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * Task entity mapped to the "tasks" table.
 * Covers: Database schema design (Project Scope - Database Interaction).
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is required")
    @Size(max = 120, message = "title must be <= 120 characters")
    @Column(nullable = false, length = 120)
    private String title;

    @Size(max = 500, message = "description must be <= 500 characters")
    @Column(length = 500)
    private String description = "";

    @Pattern(regexp = "pending|in_progress|done",
             message = "status must be pending, in_progress or done")
    @Column(nullable = false, length = 20)
    private String status = "pending";

    @Pattern(regexp = "low|medium|high",
             message = "priority must be low, medium or high")
    @Column(nullable = false, length = 20)
    private String priority = "medium";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // ---------- Constructors ----------
    public Task() {}

    public Task(String title, String description, String status, String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
    }

    // ---------- Getters / Setters ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}