package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyEx07 {
    public static void main(String[] args) {
        // 백준, 그리디 - 로프

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int weigh = 0;

        Integer[] ropes = new Integer[n];

        for(int i = 0; i < n; i++){
            ropes[i] = scan.nextInt();
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        for(int j = 1; j <= n; j++){
            weigh = Math.max(weigh, ropes[j - 1]*j);
        }
        System.out.println(weigh);

    }
}
