package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();
}
