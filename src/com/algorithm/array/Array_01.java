package com.algorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author yhlee
 * @created_at 2021-08-13 오후 4:47
 */
public class Array_01 {

    /*
    입력
    첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
    모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

    출력
    첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrayCount = Integer.parseInt(br.readLine()); // 배열 원소의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[arrayCount];
        for (int i = 0; i < arrayCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 원소 입력받기
        }

        int minP = 0; // 최소값을 가리키는 배열의 위치
        int maxP = 0; // 최대값을 가리키는 배열의 위치
        int max = arr[0];
        int min = arr[0];
        for (int curPointer = 0; curPointer < arrayCount; curPointer++) {
            if (arr[maxP] < arr[curPointer]) {
                maxP = curPointer;
                max = arr[maxP];
            }
            if (arr[minP] > arr[curPointer]) {
                minP = curPointer;
                min = arr[minP];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
