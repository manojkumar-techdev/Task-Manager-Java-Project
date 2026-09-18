package com.m604.taskmanager.exception;

/**
 * Thrown when a task with a given ID does not exist.
 */
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }
}