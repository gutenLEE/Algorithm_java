package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreedyEx06 {

    public static void main(String[]args) throws IOException {

        int sum = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subtraction = br.readLine().split("-");

        for(int i = 0; i < subtraction.length; i++){
            String [] add = subtraction[i].split("\\+");

            int temp = 0;
            for(int j = 0; j < add.length; j++){
                temp += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
