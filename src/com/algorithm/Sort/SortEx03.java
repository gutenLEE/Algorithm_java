package com.algorithm.Sort;

import java.util.Arrays;

public class SortEx03 {

    public static void main(String[] args) {

        int[] arr = fillRand(new int[10], 1, 10);
        System.out.println(Arrays.toString(arr));

        quickSort(0, arr.length - 1, arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int start, int end, int[] arr){

        // 재귀호출 종료 조건
        if(start >= end)
            return;

        // 인덱스로 사용된다.
        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){

            //피벗보다 큰 데이터를 찾을때까지
            while(left <= end && arr[left] <= arr[pivot]){
                left++;
            }
            // 피벗보다 작은 데이터를 찾을때까지
            while(right > start && arr[right] >= arr[pivot]){
                right--;
            }

            if(left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            }
            else{
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        quickSort(start, right - 1, arr);
        quickSort(right + 1, end, arr);

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
