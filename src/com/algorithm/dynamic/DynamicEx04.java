package com.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DynamicEx04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int billKinds = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());

        // 입력
        int[] bills = new int[billKinds];
        for (int i = 0; i < billKinds; i++) {
            st = new StringTokenizer(br.readLine());
            bills[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        int[] memory = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            memory[i] = 100001;
        }

        // DP :: bottom-up
        memory[0] = 0;
        for (int i = 0; i < billKinds; i++) {

            for (int j = bills[i]; j < amount + 1; j++) {
                if(memory[j - bills[i]] != 100001)
                    memory[j] = min(memory[j] , memory[j - bills[i]] + 1);
            }
        }

        if(memory[amount] == 100001)
            System.out.println(-1);
        else
            System.out.println(memory[amount]);


    }
}
