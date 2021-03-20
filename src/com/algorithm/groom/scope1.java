package com.algorithm.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class scope1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);

        ArrayList<DateItem> arrive = new ArrayList();
        ArrayList<DateItem> leave = new ArrayList();

        for(int i = 0; i < num; i++){
            String time = br.readLine();
            String[] tmp = time.split("~");
            arrive.add(new DateItem(tmp[0].trim()));
            leave.add(new DateItem(tmp[1].trim()));
        }

        Collections.sort(arrive, new SortByDate());
        Collections.sort(leave, new SortByDate());

        // a == b : 0, a < b : -1, a > b : 1
        boolean flag = true;
        for (int i = 0; i < num; i++) {
            if(arrive.get(num - 1).datetime.compareTo(leave.get(i).datetime) > 0 ||
                    leave.get(0).datetime.compareTo(arrive.get(i).datetime) < 0){
                System.out.println(-1);
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.printf("%s ~ %s", arrive.get(num - 1).datetime, leave.get(0).datetime);
    }

    static class DateItem {
        String datetime;

        DateItem(String date) {
            this.datetime = date;
        }
    }

    static class SortByDate implements Comparator<DateItem> {
        @Override
        public int compare(DateItem a, DateItem b) {
            return a.datetime.compareTo(b.datetime);
        }
    }
}
