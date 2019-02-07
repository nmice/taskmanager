package ru.neginskiy.tm.aaa;

import java.util.Date;

public class Sample {

    private String str;
    private int num;
    private Date date;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", date=" + date +
                '}';
    }
}

