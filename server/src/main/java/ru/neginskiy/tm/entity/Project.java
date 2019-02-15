package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "project")
@NoArgsConstructor
@Getter
@Setter
public class Project extends AbstractEntity {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "name")//not necessary
    private String name;
    private String description;
    private Date dateBegin;
    private Date dateEnd;
/*
    @ManyToOne
    @JoinColumn(name = "user_id")*/
    private String userId;

    @Override
    public String toString() {
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}
