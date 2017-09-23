package com.example.bunic.personalspendingtracker.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jurbunic on 23.09.17..
 */

public class DateConverter {
    /**
     * This method removes time (hours, minutes, seconds, milliseconds) from java.util.Date and leaves only date.
     * @param date Date which look like ("dd-MM-yyyy hh:mm:ss.aaa") in String.
     * @return Date which look like ("yyyy-MM-dd")
     */
    public static Date timestampToDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String stringDate = date.toString();
        stringDate = sdf.format(date);
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
