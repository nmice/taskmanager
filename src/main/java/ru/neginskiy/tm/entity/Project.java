package ru.neginskiy.tm.entity;

import java.time.LocalDate;

public class Project {

    private int projectId;
    private String projectName;
    private String projectDescription;
    private LocalDate projectDateBegin;
    private LocalDate projectDateEnd;

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public LocalDate getProjectDateBegin() {
        return projectDateBegin;
    }

    public LocalDate getProjectDateEnd() {
        return projectDateEnd;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectDateBegin(LocalDate projectDateBegin) {
        this.projectDateBegin = projectDateBegin;
    }

    public void setProjectDateEnd(LocalDate projectDateEnd) {
        this.projectDateEnd = projectDateEnd;
    }
}
