package ru.neginskiy.tm.dto;

import ru.neginskiy.tm.entity.Task;

import java.util.Date;

public class TaskJsonDTO {

    private final String id;
    private final String name;
    private final String description;
    private final Long dateBegin;
    private final Long dateEnd;
    private final String projectId;
    private final String userId;

    public TaskJsonDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dateBegin = task.getDateBegin().getTime();
        this.dateEnd = task.getDateBegin().getTime();
        this.projectId = task.getProjectId();
        this.userId = task.getUserId();
    }

    public Task getTask() {
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
}
