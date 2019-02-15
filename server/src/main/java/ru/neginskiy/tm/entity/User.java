package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    private String login;
    private String passwordHash;
}
