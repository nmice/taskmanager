package ru.neginskiy.tm.entity;

import java.util.Date;

public class Session extends AbstractEntity {

    private Date timeStamp = new Date();//default
    private String userId;
    private String signature;

    public String getUserId() {
        return userId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
