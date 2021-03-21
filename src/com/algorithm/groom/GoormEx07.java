package com.algorithm.groom;

import java.io.*;
import java.util.*;

class GoormEx07 {
    // 앰무새 꼬꼬
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] vowels = new String[] {"a", "e", "i", "o", "u"};
        for(int i = 0; i < Integer.parseInt(input); i++){
            String sentence = br.readLine();

            String result = "";
            for(int j = 0; j < sentence.length(); j++){
                for(String ch : vowels){
                    if(ch.equals((sentence.charAt(j)+"").toLowerCase())){
                        result += sentence.charAt(j)+"";
                    }
                }
            }
            if (result.equals("")) {
                System.out.println("???");
            } else {
                System.out.println(result);
            }
        }
    }
}