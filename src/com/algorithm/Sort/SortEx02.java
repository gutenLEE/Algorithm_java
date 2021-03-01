package com.algorithm.Sort;

import java.util.Arrays;

public class SortEx02 {
    public static void main(String[] args) {
        int[] arr = fillRand(new int[10], 1, 10);
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    // 배열 arr를 from과 to 범위의 값들로 채워서 반환한다.
    public static int[] fillRand(int[] arr, int from, int to){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRand(from, to);
        }
        return arr;
    }

    private static int getRand(int from, int to) {
        return (int)(Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);
    }
}
