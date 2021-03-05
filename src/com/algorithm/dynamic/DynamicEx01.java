package com.algorithm.dynamic;

import java.util.Scanner;

import static java.lang.Math.*;

public class DynamicEx01 {
    public static void main(String[] args) {
        //이.코 - 1로 만들기

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int[] dpTable = new int[x + 1];

        // bottom-up 방식
        for (int i = 2; i < x + 1; i++) {
            dpTable[i] = dpTable[i - 1] + 1;

            if(i % 2 == 0)
                dpTable[i] = min(dpTable[i], dpTable[i / 2] + 1);
            if(i % 3 == 0)
                dpTable[i] = min(dpTable[i], dpTable[i / 3] + 1);
            if(i % 5 == 0)
                dpTable[i] = min(dpTable[i], dpTable[i / 5] + 1);
        }

        System.out.println(dpTable[x]);

    }
}
