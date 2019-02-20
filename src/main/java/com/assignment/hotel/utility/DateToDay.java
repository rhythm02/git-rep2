package com.assignment.hotel.utility;

import java.util.Calendar;
import java.util.Date;

public class DateToDay {
    public int getDay(String date){
        Calendar c = Calendar.getInstance();
        Date d = null;
        try {
            d = new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        c.setTime(d);

        return c.get(Calendar.DAY_OF_WEEK);
    }
}
