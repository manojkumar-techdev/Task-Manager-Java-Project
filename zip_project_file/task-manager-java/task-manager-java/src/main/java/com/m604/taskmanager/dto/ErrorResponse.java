package com.m604.taskmanager.dto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Standard error response shape returned by the GlobalExceptionHandler.
 * Covers: Error Handling (Project Scope).
 */
public class ErrorResponse {

    private int status;
    private String error;
    private Map<String, String> details;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse() {}

    public ErrorResponse(int status, String error, Map<String, String> details) {
        this.status = status;
        this.error = error;
        this.details = details;
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public Map<String, String> getDetails() { return details; }
    public void setDetails(Map<String, String> details) { this.details = details; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}