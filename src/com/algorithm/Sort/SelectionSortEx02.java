package com.algorithm.Sort;

import com.java.OOP.InitTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SelectionSortEx02 {
    // BOJ 2750
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int stage = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 선택 정렬 수행행
       selectionSort(arr, num, stage);
    }

    private static void selectionSort(int[] arr, int num, int stage) {

        int minIdx = 0;
        for (int i = 0; i < num - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < num; j++) {

                if (arr[minIdx] > arr[j]) {
                    int tmp = arr[minIdx];
                    arr[minIdx] = arr[j];
                    arr[j] = tmp;
                }
                System.out.println(Arrays.toString(arr));
            }
            // 출력
            //System.out.println(String.join(" ", arr));
            if(i == stage - 1){
                for (int n : arr) {
                    System.out.print(n + " ");
                }
                return;
            }
        }
    }
}
