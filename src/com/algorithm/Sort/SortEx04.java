package com.algorithm.Sort;

import java.util.Arrays;

public class SortEx04 {
    // 계수 정렬
    public static void main(String[] args) {
        int min = 0;
        int max = 15;
        int [] arr = fillRand(new int[10], min, max);

        System.out.println(Arrays.toString(arr));

        int [] countSort = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countSort[arr[i]] += 1;
        }

        for (int i = 0; i < countSort.length; i++) {
            for (int j = 0; j < countSort[i]; j++) {
                System.out.print(i);
                System.out.print(", ");
            }
        }
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
