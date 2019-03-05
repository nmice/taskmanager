package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

    private String id = UUID.randomUUID().toString();
}
