package com.java.collectionFrameowork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx02 {

    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        add("f", "kim", "010-1111-1111");
        add("f", "Lim", "010-1112-1122");
        add("f", "Pim", "010-1331-3311");
        add("etc", "Mie", "010-1777-7711");
        print();

    }

    private static void add(String f, String name, String num) {
        addGroup(f);
        HashMap group = (HashMap)phoneBook.get(f);
        group.put(num, name);
    }
    private static void add(String name, String num){
        add("etc", name, num);
    }
    private static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName))
            phoneBook.put(groupName, new HashMap());// HashMap<String, Map> string : f, etc  || Map<name, num>
    }

    static void print(){
        Set set = phoneBook.entrySet(); // key, value set 반환
        Iterator it = set.iterator(); // iterator 객체 반환

        Object next = it.next();
        System.out.println("next.toString() = " + next.toString());

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next(); // String, Map

            Set subSet = ((HashMap) e.getValue()).entrySet(); // value인 Map 객체 꺼내기, 리턴 타입 set
            System.out.println("subSet = " + subSet);
            Iterator subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + "["+subSet.size() + "]");

            while (subIt.hasNext()) {
                Map.Entry subE = (Map.Entry)subIt.next();
                String telNo = (String)subE.getKey();
                String name = (String)subE.getValue();
                System.out.println(name + " " + telNo);
            }
            System.out.println();
        }
    }
}
