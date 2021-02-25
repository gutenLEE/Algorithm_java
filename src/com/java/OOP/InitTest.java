package com.java.OOP;

public class InitTest {
    static String var = "var : 명시적 초기화";
    String var2 = "인스턴스 var2 : 명시적 초기화";

    static {
        System.out.println(var);
        var = "var : 클래스 초기화 블럭";
        System.out.println(var);
    }
    {
        System.out.println(var2);
        var2 = "var2 인스턴스 초기화 블럭";
        System.out.println(var2);
    }

    InitTest(){
        var2 = "생성자 초기화 블럭";
        System.out.println(var2);
    }

    public static void main(String[] args) {
        InitTest init = new InitTest();
    }
}
