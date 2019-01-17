package ru.neginskiy.tm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateUtil {

    public static Date getDateFromStr(String str) {
        Date date = null;
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
            date = parser.parse(str);
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
        return date;
    }
}
