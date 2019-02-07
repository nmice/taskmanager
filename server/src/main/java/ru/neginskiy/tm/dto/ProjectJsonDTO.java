package ru.neginskiy.tm.dto;

import ru.neginskiy.tm.entity.Project;

import java.util.Date;

public class ProjectJsonDTO {

    private String id;
    private String name;
    private String description;
    private Long dateBegin;
    private Long dateEnd;
    private String userId;

    public ProjectJsonDTO() {
    }

    public ProjectJsonDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.dateBegin = project.getDateBegin() == null ? null : project.getDateBegin().getTime();
        this.dateEnd = project.getDateEnd() == null ? null : project.getDateEnd().getTime();
        this.userId = project.getUserId();
    }

    public Project createProject() {
        Project project = new Project();
        project.setId(getId());
        project.setName(getName());
        project.setDescription(getDescription());
        project.setDateBegin(getDateBegin() == null ? null : new Date(getDateBegin()));
        project.setDateEnd(getDateEnd() == null ? null : new Date(getDateEnd()));
        project.setUserId(getUserId());
        return project;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
