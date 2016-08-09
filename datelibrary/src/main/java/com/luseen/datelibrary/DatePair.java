package com.luseen.datelibrary;

/**
 * Created by Chatikyan on 09.08.2016-20:11.
 */

public class DatePair {

    private final int hour;
    private final int minute;

    DatePair(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
