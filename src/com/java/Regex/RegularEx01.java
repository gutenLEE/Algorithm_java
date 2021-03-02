package com.java.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx01 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat"};

        Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어

        for (int i = 0; i < data.length; i++) {
            Matcher m = p.matcher(data[i]); // pattern은 정규식을 정의하는데 사용 Matcher는 정규식(패턴)을 데이터와 비교하는 역할
            if(m.matches())
                System.out.print(data[i] + ",");
        }
    }
}
