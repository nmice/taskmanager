package ru.neginskiy.tm.entity;

import java.time.LocalDate;
import java.util.UUID;


public class Task {

    private final String taskId = UUID.randomUUID().toString();;
    private String taskName;
    private String taskDescription;
    private LocalDate taskDateBegin;
    private LocalDate taskDateEnd;
    private String projectId;//String UUID

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getTaskDateBegin() {
        return taskDateBegin;
    }

    public LocalDate getTaskDateEnd() {
        return taskDateEnd;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDateBegin(LocalDate taskDateBegin) {
        this.taskDateBegin = taskDateBegin;
    }

    public void setTaskDateEnd(LocalDate taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDateBegin=" + taskDateBegin +
                ", taskDateEnd=" + taskDateEnd +
                ", projectId='" + projectId + '\'' +
                '}';
    }
}
