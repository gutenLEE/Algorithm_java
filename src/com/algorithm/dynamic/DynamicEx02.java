package com.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DynamicEx02 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] wareHouse = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            wareHouse[i] = Integer.parseInt(st.nextToken());
        }

        int[] memory = new int[n];

        memory[0] = wareHouse[0];
        memory[1] = max(wareHouse[0], wareHouse[1]); // 1번째 창고를 털 경우와, 털지 않을 경우 중 최댓값

        for (int i = 2; i < n; i++) {
            memory[i] = max(memory[i - 1], memory[i - 2] + wareHouse[i]);
        }
        System.out.println(memory[n - 1]);

    }
}
