package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task extends AbstractEntity {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private String projectId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private String userId;

    @Override
    public String toString() {
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}