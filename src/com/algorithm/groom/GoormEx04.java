package com.algorithm.groom;

import java.io.*;
import java.util.*;

class GoormEx04 {
    //거울단어
    static Map<Character, Character> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);

        map = new HashMap();
        map.put('b', 'd'); map.put('i', 'i'); map.put('l', 'l');
        map.put('m', 'm'); map.put('o', 'o'); map.put('p', 'q');
        map.put('s', 'z'); map.put('u', 'u'); map.put('v', 'v');
        map.put('w', 'w'); map.put('x', 'x'); map.put('n', 'n');
        map.put('d', 'b'); map.put('q', 'p'); map.put('z', 's');

        for (int i = 0; i < num; i++) {
            String str = br.readLine();

            if(!chkMirror(str, map))
                System.out.println("Normal");
            else
                System.out.println("Mirror");
        }

    }

    private static boolean chkMirror(String str, Map<Character, Character> map) {

        for (int j = 0; j < str.length(); j++) {
            if(!map.containsKey(str.charAt(j)))
                return false;
        }

        int len = str.length();

        if (len % 2 == 0) {
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                if(map.get(str.charAt(i)) != str.charAt(len - (i + 1))) {
                    return false;
                }
            }
        } else {
            int mid = len / 2 + 1;
            for (int i = 0; i < mid; i++) {
                if(map.get(str.charAt(i)) != str.charAt(len - (i + 1))){
                    return false;
                }

            }
        }
        return true;
    }

}