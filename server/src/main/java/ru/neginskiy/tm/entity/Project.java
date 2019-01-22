package ru.neginskiy.tm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project extends AbstractEntity {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;
    private String userId;

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

    public String getUserId() {
        return userId;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}
