package ru.neginskiy.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Session extends AbstractEntity {

    private Date timeStamp = new Date();//default
    private String userId;
    private String signature;
}
