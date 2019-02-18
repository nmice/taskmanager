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

    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
    private String projectId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private String userId;

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}