package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "session")
@NoArgsConstructor
@Getter
@Setter
public class Session extends AbstractEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private Date timeStamp = new Date();//default
    //@ManyToOne
    //@JoinColumn(name = "userId")
    private String userId;
    private String signature;
}
