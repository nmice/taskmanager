package ru.neginskiy.tm.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Project {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private LocalDate dateBegin;
    private LocalDate dateEnd;

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

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ID: " + id +
                ", " + name +
                " (" + description +
                "), " + dateBegin +
                " - " + dateEnd;
    }
}
