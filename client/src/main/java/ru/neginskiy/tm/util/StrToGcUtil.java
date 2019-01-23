package ru.neginskiy.tm.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class StrToGcUtil {

    private static final String PATTERN = "dd-MM-yyyy";

    public static XMLGregorianCalendar getGcFromStr(String str) {

        XMLGregorianCalendar xmlGregCal;
        try {
            Date date = new SimpleDateFormat(PATTERN).parse(str);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            return null;
        }
        return xmlGregCal;
    }
}
