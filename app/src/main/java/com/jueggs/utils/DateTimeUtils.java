package com.jueggs.utils;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class DateTimeUtils
{
    public static boolean isSameDay(Date one, Date other)
    {
        return one.getDay() == other.getDay() && one.getMonth() == other.getMonth() && one.getYear() == other.getYear();
    }

    public static boolean isToday(Date date)
    {
        return isSameDay(date, new Date());
    }

    public static boolean isYesterday(Date date)
    {
        Calendar calendar = getInstance();
        calendar.roll(DAY_OF_MONTH, -1);
        return isSameDay(date, calendar.getTime());
    }
}
