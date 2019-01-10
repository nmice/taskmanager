package entity;

import java.time.LocalDate;

import static repository.TasksUtil.getNewId;

public class Task {

    private int taskId;
    private String taskName;
    private String taskDescription;
    private LocalDate taskDateBegin;
    private LocalDate taskDateEnd;
    private Project project;

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

    public Project getProject() {
        return project;
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

    public void setProject(int projectId) {
        this.project = project;
    }

    public Task(String taskName, String taskDescription, LocalDate taskDateBegin, LocalDate taskDateEnd, int projectId) {
        this.taskId = getNewId();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDateBegin = taskDateBegin;
        this.taskDateEnd = taskDateEnd;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDateBegin=" + taskDateBegin +
                ", taskDateEnd=" + taskDateEnd +
                ", projectId=" + project +
                '}';
    }
}
