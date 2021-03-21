package com.java.collectionFrameowork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx01 {
    public static void main(String[] args) {

        Map map = new HashMap<String, String>();
        map.put("A", "123");
        map.put("B", "456");
        map.put("c", "789");
        map.put("d", "101112");

        Set set = map.entrySet();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            Map.Entry e = (Map.Entry)iterator.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
