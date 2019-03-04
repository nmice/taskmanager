package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "project ")
@NoArgsConstructor
@Getter
@Setter
public class Project extends AbstractEntity {

    @Column(name = "name")//not necessary
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_begin")
    private Date dateBegin;
    @Column(name = "date_end")
    private Date dateEnd;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private transient List<Task> taskList = new ArrayList<>();

    @Override
    public String toString() {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%s (%s), %s - %s", name, description, dateBegin == null ? null : formatter.format(dateBegin), dateEnd == null ? null : formatter.format(dateEnd));
    }
}
