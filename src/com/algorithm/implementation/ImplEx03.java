package com.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplEx03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        solution(input);
    }
    public static int solution(String input){
        int row = Integer.parseInt(input.charAt(1) + "");
        int col = input.charAt(0) - 97 + 1;

        int [][] steps = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };

        int result = 0;
        for(int[] step: steps) {
            int nextR = row + step[0];
            int nextC = col + step[1];

            if (nextR >= 1 && nextR <= 8 && nextC >= 1 && nextC <= 8)
                result++;
        }
        System.out.println(result);
        return result;
    }
}
