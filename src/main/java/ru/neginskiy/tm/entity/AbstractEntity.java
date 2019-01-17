package ru.neginskiy.tm.entity;

import ru.neginskiy.tm.api.IEntity;

import java.util.Date;
import java.util.UUID;

public class AbstractEntity implements IEntity {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;

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
}
