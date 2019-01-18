package ru.neginskiy.tm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateUtil {

    private static final String PATTERN = "dd-MM-yyyy";

    public static Date getDateFromStr(String str) {
        try {
            return new SimpleDateFormat(PATTERN).parse(str);
        } catch (Exception e) {
            return null;
        }
    }
}
