package com.m604.taskmanager.config;

import com.m604.taskmanager.model.Task;
import com.m604.taskmanager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Adds sample tasks at startup (only if the DB is empty).
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final TaskRepository repo;

    public DataInitializer(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new Task("Buy groceries", "milk and bread", "pending", "medium"));
            repo.save(new Task("Finish assignment", "M604 project", "in_progress", "high"));
            repo.save(new Task("Call mom", "", "done", "low"));
            System.out.println(">> Sample tasks inserted.");
        }
    }
}