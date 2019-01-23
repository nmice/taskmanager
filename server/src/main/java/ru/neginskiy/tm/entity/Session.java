package ru.neginskiy.tm.entity;

import java.util.Date;

public class Session extends AbstractEntity {

    private String userId;
    private Date dateBegin;
    private String signature;

    public String getUserId() {
        return userId;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
