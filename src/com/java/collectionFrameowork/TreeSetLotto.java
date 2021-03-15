package com.java.collectionFrameowork;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {
    public static void main(String[] args) {

        Set treeSet = new TreeSet<>();

        for (int i = 0; treeSet.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            treeSet.add(num);
        }
        System.out.println(treeSet);


        // subSet 메서드
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dzzz");
        set.add("Dzzz");

        System.out.println(set);
        System.out.println("range search : from " + from + " to = " + to);
        System.out.println("result1 : " + set.subSet(from,to));
        System.out.println("Result2 : " + set.subSet(from, to + "zzz"));

    }




}
