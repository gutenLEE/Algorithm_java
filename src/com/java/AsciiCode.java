package com.java;

import java.util.Scanner;

public class AsciiCode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char ch = scan.nextLine().charAt(0);
        toInt(ch);

        int num = scan.nextInt();
        toChar(num);
    }

    static void toChar(int num){
        char ch = (char)num;
        System.out.println(ch);
    }
    static void toInt(char ch){
        int num = (int)ch;
        System.out.println(num);
    }
}
