package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password_hash")
    private String passwordHash;
}
