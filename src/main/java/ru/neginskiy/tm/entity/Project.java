package ru.neginskiy.tm.entity;

import java.util.Date;
import java.util.UUID;

public class Project {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private Date dateBegin;//todo change to Date
    private Date dateEnd;//todo change to Date

    public String getId() {
        return id;
    }

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

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ID:" + id +
                ", " + name +
                " (" + description +
                "), " + dateBegin +
                " - " + dateEnd;
    }
}
