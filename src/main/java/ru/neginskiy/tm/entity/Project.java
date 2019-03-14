package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Project extends AbstractEntity {

    private String name = "NEW PROJECT";
    private String description;
    private Date dateBegin;
    private Date dateEnd;

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}
