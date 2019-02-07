package ru.neginskiy.tm.dto;

import ru.neginskiy.tm.entity.Task;

import java.util.Date;

public class TaskJsonDTO {

    private String id;
    private String name;
    private String description;
    private Long dateBegin;
    private Long dateEnd;
    private String projectId;
    private String userId;

    public TaskJsonDTO() {
    }

    public TaskJsonDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dateBegin = task.getDateBegin() == null ? null : task.getDateBegin().getTime();
        this.dateEnd = task.getDateEnd() == null ? null : task.getDateEnd().getTime();
        this.projectId = task.getProjectId();
        this.userId = task.getUserId();
    }

    public Task createTask() {
        Task task = new Task();
        task.setId(getId());
        task.setName(getName());
        task.setDescription(getDescription());
        task.setDateBegin(getDateBegin() == null ? null : new Date(getDateBegin()));
        task.setDateEnd(getDateEnd() == null ? null : new Date(getDateEnd()));
        task.setProjectId(getProjectId());
        task.setUserId(getUserId());
        return task;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getDateBegin() {
        return dateBegin;
    }

    public Long getDateEnd() {
        return dateEnd;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateBegin(Long dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(Long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
