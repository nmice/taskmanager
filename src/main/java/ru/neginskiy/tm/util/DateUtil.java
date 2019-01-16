package ru.neginskiy.tm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

    public static final long ONE_DAY = 86_400_000;//Min period

    public static String getCorrectStrOrDefault(String str, String defaultValue) {
        if (str == null || str.isEmpty()) {
            System.out.println("Incorrect input, default is " + defaultValue);
            return defaultValue;
        }
        return str;
    }

    public static Date getDateBeginFromKbOrDefault() {
        Scanner scanner = new Scanner(System.in);
        String strFromKb = scanner.nextLine();
        Date date;
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
            date = parser.parse(strFromKb);
        } catch (Exception e) {
            System.out.println("Incorrect input, the default date is now");
            date = new Date(System.currentTimeMillis());
        }
        return date;
    }

    public static Date getDateEndFromKbOrDefault() {
        Scanner scanner = new Scanner(System.in);
        String strFromKb = scanner.nextLine();
        Date date;
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
            date = parser.parse(strFromKb);
        } catch (Exception e) {
            System.out.println("Incorrect input, the default date is now");
            date = new Date(System.currentTimeMillis());
        }
        return date;
    }
}
