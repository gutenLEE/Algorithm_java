package com.java.collectionFrameowork;

import java.util.Stack;

public class StackEx01 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("1. 네이트");
        goURL("2. yahoo");
        goURL("3. Naver");
        goURL("4. Daum");

        printStatus();

        goBack();
        System.out.println("뒤로가기 버튼을 누른 후");
        printStatus();

        goBack();
        System.out.println("뒤로가기 버튼을 누른 후");
        printStatus();

        goforward();
        System.out.println("앞으로 버튼을 누른 후");
        printStatus();

        goURL("tistory");
        System.out.println("새로운 주소로 이동 후");
        printStatus();


    }

    private static void goforward() {
        if(!back.empty())
            back.push(forward.pop());
    }

    private static void goBack() {
        if(!back.empty())
            forward.push(back.pop());
    }

    private static void printStatus() {
        System.out.println("back: " + back);
        System.out.println("forward: " + forward);
        System.out.println("현재화면은 " + back.peek() + " 입니다.");
        System.out.println();
    }

    private static void goURL(String s) {
        back.push(s);
        if(!forward.isEmpty())
            forward.clear();
    }
}
