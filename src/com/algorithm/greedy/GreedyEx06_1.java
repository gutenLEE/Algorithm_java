package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreedyEx06_1 {
    public static void main(String[] args) throws IOException {

        // 잃어버린 괄호 - stringTokenizer 로 구현하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer subtraction = new StringTokenizer(br.readLine());

        while(subtraction.hasMoreTokens()){
            int temp = 0;
            
            StringTokenizer add = new StringTokenizer(subtraction.nextToken(), "+");

            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }
    }
}
