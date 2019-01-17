package ru.neginskiy.tm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends AbstractEntity {

    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;
    private String projectId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public Date getDateEnd() {
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

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return name + " (" + description + "), " + formatter.format(dateBegin) + " - " + formatter.format(dateEnd);
    }

}