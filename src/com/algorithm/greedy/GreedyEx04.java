package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyEx04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] arr = br.readLine().split(" ");

        int [] numArr = new int[n];

        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numArr);

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                result += numArr[j];
            }
        }
        System.out.println(result);
    }
}
