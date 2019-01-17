package ru.neginskiy.tm.api;

import java.util.Date;

public interface IEntity {

    String getId();

    String getName();

    String getDescription();

    Date getDateBegin();

    Date getDateEnd();

    void setName(String name);

    void setDescription(String description);

    void setDateBegin(Date dateBegin);

    void setDateEnd(Date dateEnd);
}
