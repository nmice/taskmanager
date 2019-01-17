package ru.neginskiy.tm.entity;

import java.util.UUID;

public abstract class AbstractEntity {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

}
