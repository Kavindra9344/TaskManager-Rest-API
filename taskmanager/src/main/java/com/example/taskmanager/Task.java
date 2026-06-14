package com.example.taskmanager;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="Task")
@Table(name="task")
public class Task {

    @Id
    @SequenceGenerator(
            name="task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private int id;

    @Column(
            name="title",
            nullable = false
    )
    private String title;

    @Column(
            name="description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(nullable = false)
    private String Status;

    @Column(
            name="created_at"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "due_date"
    )
    private LocalDate dueDate;

    public Task(){

    }


    public Task(int id, String title, String description, String status, LocalDateTime createdAt, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        Status = status;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
