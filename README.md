# DateHelper
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-DateHelper-green.svg?style=true)](https://android-arsenal.com/details/1/4041)

Simple dateHelper, that can help you to make your life easy.
Just give date to dateHelper and get in different format

![](screen_new.png)

Download
--------

Gradle:
```groovy
compile 'com.github.armcha:datehelper:2.0.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.armcha</groupId>
  <artifactId>datehelper</artifactId>
  <version>2.0.0</version>
  <type>pom</type>
</dependency>
```

Usage
--------

```java
Date currentDate = new Date();
DateHelper dateHelper = new DateHelper(currentDate)

dateHelper.getDay() ------------------- 13
dateHelper.getMonthLongName() ------ April
dateHelper.getHour() --------------- 13:30
dateHelper.getHourWithAMPM() ----- 1:30 AM
dateHelper.getHourIn12HourFormat() -- 1:30
dateHelepr.getDateAMPM() -------------- AM
dateHelepr.getMonthShortName() ------- Apr
dateHelper.getDayOfTheWeek() --- Wednesday
dateHelper.getDayOfWeekShortName() --- Wed
dateHelper.getMonth() ----------------- 04
dateHelper.getYear() ---------------- 1993
```

You can also add current time zone offset to your date, just adding this line 
```java
dateHelper.shouldAddCurrentTimeZoneOffsetToDate();
```

We also have string to date static method, just call it in this way
```java
DateConverter.stringToDate(String yourDate,String dateTemplate)
```

Get current time zone hour and minute offset
```java
DateConverter.getCurrentTimeZoneOffset().getHour()
DateConverter.getCurrentTimeZoneOffset().getMinute()
```

Get current given date
```java
dateHelper.getGivenDate()
```

Change text place holder in case you have null date
```java
dateHelper.setNullDateText("Your place holder");
```
[1]: https://github.com/armcha/DateHelper/blob/master/datelibrary/src/main/java/com/luseen/datelibrary/DatePatterns.java
Now we have a lot of date patterns, you can find patterns inside [DatePatterns][1]  class 
```java
DateConverter.stringToDate("1993 Apr 13", DatePatterns.SIMPLE_DATE_PATTERN_WITH_DAY.toString())
```

## Contact 

Pull requests are more than welcome.
Please fell free to contact me if there is any problem when using the DateHelper.

- **Email**: armcha01@gmail.com
- **Facebook**: https://web.facebook.com/chatikyana
- **Google +**: https://plus.google.com/112011638040018774140
- **Website**: http://luseen.com/

License
--------


          Copyright 2016 Arman Chatikyan

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.
    

