package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task extends AbstractEntity {

    @Column(name = "name")//not necessary
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_begin")
    private Date dateBegin;
    @Column(name = "date_end")
    private Date dateEnd;
    @ManyToOne
    private Project project;
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}