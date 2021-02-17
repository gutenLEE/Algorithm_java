package com.algorithm.greedyEx02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyEx02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        String[] minArr = new String[row];

        for(int i = 0; i < row; i++){
            String inputs = br.readLine();
            String[] cards = inputs.split(" ");

            Arrays.sort(cards);
            minArr[i] = cards[0];
        }

        Arrays.sort(minArr);
        System.out.println(minArr[row - 1]);

    }
}
