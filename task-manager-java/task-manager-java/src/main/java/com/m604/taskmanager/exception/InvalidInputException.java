package com.m604.taskmanager.exception;

/**
 * Thrown when client sends invalid data (bad status, bad priority, etc.).
 */
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}