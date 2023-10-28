package com.space.and.beyond.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;

public class DateUtils {

    private DateUtils(){
    }

    public static String getDateAsString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(date);
    }

    public static int getDateAsInt(Date date, String format) {
        return Integer.parseInt(getDateAsString(date, format));
    }

    public static String getCurrentDate(String format) {
        return getDateAsString(new Date(), format);
    }

    public static Date parseString(String dateAsString, String format) {
        Date date = new Date();
        SimpleDateFormat sdf;
        try {
            sdf = new SimpleDateFormat(format, Locale.US);
            date = sdf.parse(dateAsString);
        } catch (ParseException e) {
            Report.reportFail(String.format(FAIL, e.getMessage()));
        }
        return date;
    }

}
