package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String login;
    private String passwordHash;
}
