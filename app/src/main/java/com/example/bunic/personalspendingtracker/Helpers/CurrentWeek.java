package com.example.bunic.personalspendingtracker.Helpers;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jurbunic on 04.10.17..
 */

public class CurrentWeek {
    private static Date dateStart;
    private static Date dateEnd;
    private static Calendar calendar;

    static {
        calendar = Calendar.getInstance();
        setTime();
    }


    public static Date getDateStart() {
        return dateStart;
    }

    public static Date getDateEnd() {
        return dateEnd;
    }

    private static void removeTime(){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setTime(){
        calendar.add(Calendar.DAY_OF_YEAR,-3);
        removeTime();
        dateStart = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR,+7);
        removeTime();
        dateEnd = calendar.getTime();
    }
}
