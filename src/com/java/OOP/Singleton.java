package com.java.OOP;

public class Singleton {

    private static Singleton s = new Singleton(); // getInstance에서 사용될 수 있도록 인스턴스가 미리 생성.

    private Singleton() { }

    public static Singleton getInstance(){
        return s;
    }
}
