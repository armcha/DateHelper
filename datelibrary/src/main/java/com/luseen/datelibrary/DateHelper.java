package com.luseen.datelibrary;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Chatikyan on 19.04.2016.
 */
public class DateHelper {

    private Date date;

    private Locale locale = Locale.getDefault();

    private SimpleDateFormat simpleDateFormat;

    private boolean addCurrentTimeZoneOffsetToDate = false;

    private String nullDateText = "-";

    private static final String LOG_TEXT = "date must not be null";


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
            return nullDateText;
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
            return nullDateText;
        }
    }

    @Nullable //13:30
    public String getHour() {
        simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //1:30 AM
    public String getHourWithAMPM() {
        simpleDateFormat = new SimpleDateFormat("h:mm a", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //1:30
    public String getHourIn12HourFormat() {
        simpleDateFormat = new SimpleDateFormat("h:mm", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //AM/PM
    public String getDateAMPM() {
        simpleDateFormat = new SimpleDateFormat("a", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //Apr
    public String getMonthShortName() {
        simpleDateFormat = new SimpleDateFormat("MMM", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //Wednesday
    public String getDayOfTheWeek() {
        simpleDateFormat = new SimpleDateFormat("EEEE", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //Wed
    public String getDayOfWeekShortName() {
        simpleDateFormat = new SimpleDateFormat("EEE", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
        }
    }

    @Nullable //04
    public String getMonth() {
        simpleDateFormat = new SimpleDateFormat("MM", locale);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            Log.e(DateHelper.class.getSimpleName(), LOG_TEXT);
            return nullDateText;
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
            return nullDateText;
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
     * Adding current time zone offset
     *
     * @param date target date to add time zone offset
     * @return date with time zone offset
     */
    private Date addTimezoneOffsetToDate(Date date) {
        DatePair hourAndMinuteOffset = DateConverter.getCurrentTimeZoneOffset();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAndMinuteOffset.getHour());
        calendar.add(Calendar.MINUTE, hourAndMinuteOffset.getMinute());

        return calendar.getTime();
    }

    /**
     * if you want addCurrentTimeZoneOffset to your date, just call this method
     */
    public void shouldAddCurrentTimeZoneOffsetToDate() {
        addCurrentTimeZoneOffsetToDate = true;
    }

    /**
     * set text in case if your date is null
     *
     * @param nullDateText text to set for null date
     */
    public void setNullDateText(String nullDateText) {
        this.nullDateText = nullDateText;
    }

    /**
     * get given date
     *
     * @return date
     */
    public Date getGivenDate() {
        if (date == null) {
            Log.e("GETTING GIVEN DATE ", "GIVEN DATE IS NULL!!!");
            return null;
        } else
            return date;
    }
}
