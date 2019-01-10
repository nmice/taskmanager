package ru.neginskiy.tm.entity;

import java.time.LocalDate;

public class Task {

    private int taskId;
    private String taskName;
    private String taskDescription;
    private LocalDate taskDateBegin;
    private LocalDate taskDateEnd;
    private int projectId;

    public int getTaskId() {
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

    public int getProjectId() {
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

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Task(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, int projectId) {
/*        this.taskId = getNewId();*/
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDateBegin = taskDateBegin;
        this.taskDateEnd = taskDateEnd;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDateBegin=" + taskDateBegin +
                ", taskDateEnd=" + taskDateEnd +
                ", projectId=" + projectId +
                '}';
    }
}
