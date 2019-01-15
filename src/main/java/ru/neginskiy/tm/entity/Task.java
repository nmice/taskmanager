package ru.neginskiy.tm.entity;

import java.time.LocalDate;
import java.util.UUID;


public class Task {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private String projectId = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", " + name +
                " (" + description +
                "), " + dateBegin +
                " - " + dateEnd +
                ", projectId: " + projectId;
    }
}