package com.java.Regex;

import java.util.regex.Pattern;

/**
 * @author yhlee
 * @created_at 2021-08-19 오후 2:06
 */
public class Regex01 {
    public static void main(String[] args) {

        String pattern = "(고졸|대졸|석사|박사|학력무관)?\\s?~?\\s?(고졸|대졸|석사|박사|학력무관)?(\\(\\d*~?\\d*년\\))?";

        String[] arr = {"석사", "박사", "고졸", "학력무관", "고졸 ~ 석사(4년)", "고졸(3년)", "4년"};

        for (int i = 0; i < arr.length; i++) {
            String val = arr[i];
            boolean matches = Pattern.matches(pattern, val);
            if(matches) System.out.println("일치");
            else System.out.println("불일치");
        }

    }
}
