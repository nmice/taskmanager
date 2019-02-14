package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "session")
@NoArgsConstructor
@Getter
@Setter
public class Session extends AbstractEntity {

    private Date timeStamp = new Date();//default

    @ManyToOne
    @JoinColumn(name = "userId")
    private String userId;
    private String signature;
}
