package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyEx05 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int kinds = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int num [] = new int[kinds];

        for(int i = 0; i < kinds; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        int cnt = 0;
        int tmp = amount;
        for(int i = kinds - 1; i >= 0; i--){
            if(tmp % num[i] < amount){
                cnt += tmp / num[i];
                tmp %= num[i];
            }
        }
        System.out.println(cnt);
    }
}
