package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
@NoArgsConstructor
@Getter
@Setter
public class Session extends AbstractEntity {

    @Column(name = "time_stamp")
    private Date timeStamp = new Date();//default
    @ManyToOne
    private User user;
    @Column(name = "signature")
    private String signature;
}
