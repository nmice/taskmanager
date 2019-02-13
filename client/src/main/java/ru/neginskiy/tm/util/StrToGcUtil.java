package ru.neginskiy.tm.util;

import org.jetbrains.annotations.Nullable;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class StrToGcUtil {

    private static final String PATTERN = "dd-MM-yyyy";

    public static @Nullable XMLGregorianCalendar getGcFromStr(@Nullable final String str) {
        XMLGregorianCalendar xmlGregCal;
        try {
            final Date date = new SimpleDateFormat(PATTERN).parse(str);
            final GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            return null;
        }
        return xmlGregCal;
    }
}