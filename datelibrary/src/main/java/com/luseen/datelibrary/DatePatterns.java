package com.luseen.datelibrary;

/**
 * Created by Chatikyan on 08.08.2016-18:22.
 */

public enum DatePatterns {

    SIMPLE_DATE_PATTERN("yyyy MMM"),
    SIMPLE_DATE_PATTERN_WITH_DAY("yyyy MMM dd"),
    DATE_PATTERN_WITH_T("yyyy-MM-dd'T'HH:mm:ss"),
    DATE_PATTERN_DATE_PATTERN_WITH_T_AND_AP_PM_WITH_T("yyyy-MM-dd'T'hh:mm:ss a"),
    USUAL_DATE_PATTERN("yyyy-MM-dd HH:mm:ss"),
    ISO8601_DATE_PATTERN("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    ISO8601_DATE_PATTERN_SECOND_TYPE("yyyy/MM/dd'T'HH:mm:ss'Z'"),
    PATTERN_1("EEE MMM dd HH:mm:ss yyyy"),
    PATTERN_2("yyyy-MM-dd'T'HH:mm:ss"),
    PATTERN_3("yyyy-MM-dd HH:mm:ss"),
    PATTERN_4("yyyy-MM-dd HH:mm:ss Z"),
    PATTERN_5("yyyy-MM-dd'T'HH:mm:ssZ"),
    PATTERN_6("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    PATTERN_7("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    PATTERN_8("yyyy-MM-dd'T'HH:mm:ss Z"),
    PATTERN_9("dd/MM/yyyy"),
    PATTERN_10("dd-MM-yyyy HH:mm:ss"),
    PATTERN_11("dd-MMM-yyyy"),
    PATTERN_12("MM dd, yyyy"),
    PATTERN_13("E, MMM dd yyyy"),
    PATTERN_14("E, MMM dd yyyy HH:mm:ss"),
    PATTERN_15("yyyy-MMM-dd");

    private String datePattern;

    DatePatterns(String toString) {
        datePattern = toString;
    }

    @Override
    public String toString() {
        return datePattern;
    }
}
