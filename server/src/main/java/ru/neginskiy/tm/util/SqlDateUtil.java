package ru.neginskiy.tm.util;

import java.util.Date;

public class SqlDateUtil {

    public static java.sql.Date prepare(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static Date prepare(java.sql.Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }


}
