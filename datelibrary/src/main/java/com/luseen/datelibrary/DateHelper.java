package com.luseen.datelibrary;

import android.support.annotation.Nullable;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Chatikyan on 19.04.2016.
 */
public class DateHelper {

    private Date date;

    private Locale locale = Locale.getDefault();

    private SimpleDateFormat simpleDateFormat;

    private boolean addCurrentTimeZoneOffsetToDate = false;

    private static final String NULL_DATE = "-";

    private static final String LOG_TEXT = "date must not be null";

    public static final String SIMPLE_DATE_PATTERN = "yyyy MMM";

    public static final String DATE_PATTERN_WITH_T = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String DATE_PATTERN_WITH_T_AND_AP_PM = "yyyy-MM-dd'T'hh:mm:ss a";

    public static final String USUAL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static final String EVENT_TIMESTAMP_DATE_PATTERN = "yyyy/MM/dd'T'HH:mm:ss'Z'";


    public DateHelper(Date date) {
        if (addCurrentTimeZoneOffsetToDate) {
            this.date = addTimezoneOffsetToDate(date);
        } else {
            this.date = date;
        }
    }

    public DateHelper(Date date, Locale locale) {
        if (addCurrentTimeZoneOffsetToDate) {
            this.date = addTimezoneOffsetToDate(date);
        } else {
            this.date = date;
        }
    }

    @Nullable //13
    public String getDay() {
        simpleDateFormat = new SimpleDateFormat("dd", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    //13
    public int getIntDay() {
        simpleDateFormat = new SimpleDateFormat("dd", locale);
        if (date != null) {
            return Integer.parseInt(simpleDateFormat.format(date));
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return 0;
        }
    }

    @Nullable //April
    public String getMonthLongName() {
        simpleDateFormat = new SimpleDateFormat("MMMM", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //13:30
    public String getHour() {
        simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //1:30 AM
    public String getHourWithAMPM() {
        simpleDateFormat = new SimpleDateFormat("h:mm a", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //1:30
    public String getHourIn12HourFormat() {
        simpleDateFormat = new SimpleDateFormat("h:mm", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //AM/PM
    public String getDateAMPM() {
        simpleDateFormat = new SimpleDateFormat("a", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //Apr
    public String getMonthShortName() {
        simpleDateFormat = new SimpleDateFormat("MMM", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //Wednesday
    public String getDayOfTheWeek() {
        simpleDateFormat = new SimpleDateFormat("EEEE", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //Wed
    public String getDayOfWeekShortName() {
        simpleDateFormat = new SimpleDateFormat("EEE", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    @Nullable //04
    public String getMonth() {
        simpleDateFormat = new SimpleDateFormat("MM", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    //04
    public int getIntMonth() {
        simpleDateFormat = new SimpleDateFormat("MM", locale);
        if (date != null) {
            return Integer.parseInt(simpleDateFormat.format(date));
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return 0;
        }
    }

    @Nullable //1993
    public String getYear() {
        simpleDateFormat = new SimpleDateFormat("yyyy", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return NULL_DATE;
        }
    }

    //1993
    public int getIntYear() {
        simpleDateFormat = new SimpleDateFormat("yyyy", locale);
        if (date != null) {
            return Integer.parseInt(simpleDateFormat.format(date));
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return 0;
        }
    }

    /**
     * Convert date from String to Date format
     *
     * @param date         string date
     * @param dateTemplate for parsing
     * @return formatted Date
     */
    public static Date stringToDate(String date, String dateTemplate) {

        DateFormat format = new SimpleDateFormat(dateTemplate, Locale.getDefault());

        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert date from String to Date format
     *
     * @param date         string date
     * @param dateTemplate for parsing
     * @param locale       choose locale
     * @return formatted Date
     */
    public static Date stringToDate(String date, String dateTemplate, Locale locale) {

        DateFormat format = new SimpleDateFormat(dateTemplate, locale);

        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * hourAndMinuteOffset[0] hour offset
     * hourAndMinuteOffset[1] minute offset
     *
     * @param locale current locale
     * @return hourAndMinuteOffset array, current time zone offset
     */
    private int[] getCurrentTimeZoneOffset(Locale locale) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(),
                Locale.getDefault());
        Date currentLocalTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("Z", locale);
        String localTime = date.format(currentLocalTime);

        int hourOffset = Integer.valueOf(localTime.substring(1, 3));
        int minuteOffset = Integer.valueOf(localTime.substring(3, localTime.length()));
        int[] hourAndMinuteOffset = new int[2];
        hourAndMinuteOffset[0] = hourOffset;
        hourAndMinuteOffset[1] = minuteOffset;

        return hourAndMinuteOffset;
    }

    /**
     * Adding current time zone offset
     *
     * @param date target date to add time zone offset
     * @return date with time zone offset
     */
    private Date addTimezoneOffsetToDate(Date date) {
        int[] hourAndMinuteOffset = getCurrentTimeZoneOffset(Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAndMinuteOffset[0]);
        calendar.add(Calendar.MINUTE, hourAndMinuteOffset[1]);

        return calendar.getTime();
    }

    /**
     * if you want addCurrentTimeZoneOffset to your date, just call this method
     */
    public void shouldAddCurrentTimeZoneOffsetToDate() {
        addCurrentTimeZoneOffsetToDate = true;
    }
}
