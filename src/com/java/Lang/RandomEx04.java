package com.java.Lang;

import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class RandomEx04 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(getRand(5, 10) + ",");
        }
        System.out.println();

        int[] result = fillRand(new int[10], new int[]{2, 3, 7, 5});
        System.out.println(Arrays.toString(result));
    }

    // 배열 arr를 from과 to 범위의 값들로 채워서 반환한다.
    public static int[] fillRand(int[] arr, int from, int to){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRand(from, to);
        }
        return arr;
    }

    // data에 있는 값들로 채워서 반환한다.
    private static int[] fillRand(int[] arr, int[] data) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = data[getRand(0, data.length - 1)];
        }
        return arr;
    }

    private static int getRand(int from, int to) {
        return (int)(Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);
    }
}
