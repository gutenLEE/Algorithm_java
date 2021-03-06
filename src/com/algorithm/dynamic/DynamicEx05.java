package com.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DynamicEx05 {
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        // 입력받기
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            fibonacci(x);
            System.out.println(dp[x][0] + " " + dp[x][1]);
        }
    }
    public static Integer[] fibonacci(int n){

        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }
}
