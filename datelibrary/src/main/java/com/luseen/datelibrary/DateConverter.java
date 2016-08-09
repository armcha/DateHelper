package com.luseen.datelibrary;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Chatikyan on 09.08.2016-11:15.
 */

public class DateConverter {

    /**
     * Convert date from String to Date format
     *
     * @param date        string date
     * @param datePattern for parsing
     * @return formatted Date
     */
    public static Date stringToDate(String date, String datePattern) {

        DateFormat format = new SimpleDateFormat(datePattern, Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            Log.e(" " + e.getMessage(), " Please check if you have valid pattern! ");
        }
        return null;
    }

    /**
     * Convert date from given Strings to Date format
     *
     * @param date         string date
     * @param datePatterns patterns for parsing
     * @return formatted Date
     */
    public static Date stringToDate(String date, String... datePatterns) {

        for (String datePattern : datePatterns) {
            DateFormat format = new SimpleDateFormat(datePattern, Locale.ENGLISH);
            try {
                return format.parse(date);
            } catch (ParseException e) {
                if (datePatterns.length > 1)
                    Log.e("Trying to parse ", "Failed, trying next pattern");
                else
                    Log.e("Trying to parse ", "Failed to parse");
            }
        }
        return null;
    }

    /**
     * hourAndMinuteOffset[0] hour offset
     * hourAndMinuteOffset[1] minute offset
     *
     * @return hourAndMinuteOffset array, current time zone offset
     */
    public static DatePair getCurrentTimeZoneOffset() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(),
                Locale.getDefault());
        Date currentLocalTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("Z", Locale.getDefault());
        String localTime = date.format(currentLocalTime);

        int hourOffset = Integer.valueOf(localTime.substring(1, 3));
        int minuteOffset = Integer.valueOf(localTime.substring(3, localTime.length()));

        return new DatePair(hourOffset, minuteOffset);
    }
}
