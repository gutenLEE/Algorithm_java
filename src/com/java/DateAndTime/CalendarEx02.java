package com.java.DateAndTime;

import java.util.Calendar;

public class CalendarEx02 {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        date.set(2005, 7, 31);

        System.out.println(toString(date));
        date.add(Calendar.DATE, 1);
        System.out.println(toString(date));

        date.add(Calendar.MONTH, -6);
        System.out.println(toString(date));

        // roll 필드는 월 필드의 값은 변하지 않고 필드 값만 바뀐다.
        date.roll(Calendar.DATE, 31);
        System.out.println(toString(date));

        date.add(Calendar.DATE, 31);
        System.out.println(toString(date));
    }
    public static String toString(Calendar date){
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일";
    }
}
