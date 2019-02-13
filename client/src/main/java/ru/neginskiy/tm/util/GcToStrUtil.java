package ru.neginskiy.tm.util;

import org.jetbrains.annotations.Nullable;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;

public class GcToStrUtil {

    private static final String PATTERN = "dd-MM-yyyy";

    public static @Nullable String getStrFromGc(@Nullable final XMLGregorianCalendar xmlGregCal) {
        if (xmlGregCal == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(PATTERN).format(xmlGregCal.toGregorianCalendar().getTime());
        } catch (Exception e) {
            return null;
        }
    }
}
