package ru.neginskiy.tm.util;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

    public static Date getFormattedDateFromKb(String dateTypeMsg, String stringFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(stringFormat);
        Date date = null;
        Scanner scanner = new Scanner(System.in);
        try {
            String strFromKb = scanner.nextLine();
            SimpleDateFormat parser = new SimpleDateFormat(stringFormat);
            date = parser.parse(strFromKb);
            return date;
        } catch (Exception e) {
            System.out.println("Incorrect date format, please try again.\r\nEnter a " + dateTypeMsg + " in the format DD-MM-YYYY :");
        }
        return null;
    }
}
