package com.java.collectionFrameowork;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListEx01 {
    public static void main(String[] args) {
         ArrayList arrayList = new ArrayList(30);
        for (int i = 0; i < 30; i++) {
            arrayList.add(i + "");
        }

        LinkedList linkedList = new LinkedList(arrayList);
        for (int i = 0; i < 3; i++) {
            linkedList.add(23, "X");
        }

        for (Object elm : linkedList) {
            System.out.print(elm.toString() + " ");
        }
    }
}
