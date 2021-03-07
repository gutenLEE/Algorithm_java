package com.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicEx06 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        // 메모제이션
        int[] sugar = {3, 5};
        Integer[] dp = new Integer[5001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 5001;
        }

        dp[3] = 1;
        dp[5] = 1;

        if(n > 5){
            for (int kilogram : sugar) {
                for (int i = 6; i < n + 1; i++) {
                    if(dp[i - kilogram] != 5001){
                        dp[i] = Math.min(dp[i], dp[i - kilogram] + 1);
                    }
                }
            }
        }

        if (dp[n] == 5001)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }

}
