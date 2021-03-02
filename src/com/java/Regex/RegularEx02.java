package com.java.Regex;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx02 {
    static String str = "The spread of highly contagious coronavirus variants is threatening " +
            "to fuel a \"potential fourth surge of cases\" in the US, ca " +
            "a top health official has warned. 하이하이 c23 c234";

    public static void main(String[] args) {
        runRgx(Pattern.compile("c[a-z]*"));
        runRgx(Pattern.compile("c[a-z]"));
        runRgx(Pattern.compile("c[a-zA-Z]"));
        runRgx(Pattern.compile("c[a-zA-Z0-9]*"));
        runRgx(Pattern.compile(".*"));
        runRgx(Pattern.compile("c.*"));
        runRgx(Pattern.compile("c\\."));
        runRgx(Pattern.compile("c\\d"));
        runRgx(Pattern.compile("c.*t"));
        runRgx(Pattern.compile("[b|c].*"));
        runRgx(Pattern.compile("[^b|c].*"));
        runRgx(Pattern.compile(".*a.*"));
        runRgx(Pattern.compile(".*a.+"));
        runRgx(Pattern.compile("[b|c].{2}"));
        runRgx(Pattern.compile("^[가-힣]*$"));
    }

    private static void runRgx(Pattern p) {
        System.out.println("===========================");
        System.out.println("정규식 : " + p.pattern());

        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreElements()){
            String token = st.nextToken();
            Matcher m = p.matcher(token);
            if(m.matches())
                System.out.print(token + ", ");
        }
        System.out.println();
    }
}

//        System.out.println();
//                Matcher m2 = p.matcher(str);
//                while(m2.find()){
//                System.out.print(m2.group() + " ");
//                }
//                System.out.println();