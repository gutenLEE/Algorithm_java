package com.java.DateAndTime;

import java.util.Calendar;

public class CalendarEx01 {

    public static void main(String[] args) {
        final int[] TIME_UNIT = {3600, 60, 1};
        final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};

        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        time1.set(Calendar.HOUR_OF_DAY, 10);
        time1.set(Calendar.MINUTE, 23);
        time1.set(Calendar.SECOND, 14);

        time2.set(Calendar.HOUR_OF_DAY, 20);
        time2.set(Calendar.MINUTE, 34);
        time2.set(Calendar.SECOND, 55);

        System.out.println("time1 - " + time1.get(Calendar.HOUR_OF_DAY) + ":" + time1.get(Calendar.MINUTE) + ":" + time1.get(Calendar.SECOND));
        System.out.println("time2 - " + time2.get(Calendar.HOUR_OF_DAY) + ":" + time2.get(Calendar.MINUTE) + ":" + time2.get(Calendar.SECOND));

        long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis() / 1000);
        System.out.println(difference);

        Calendar today = Calendar.getInstance();
        System.out.println(today.get(Calendar.YEAR));

        String tmp = "";
        for (int i = 0; i < TIME_UNIT.length; i++) {
            tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
            difference %= TIME_UNIT[i];
        }
        System.out.println(tmp);
    }
}
