package com.algorithm.Sort;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortEx05 {
    public static void main(String[] args) {
        //위에서 아래로 - 이.코 178p

        Scanner scanner = new Scanner(System.in);
        int arrCnt = scanner.nextInt();

        int[] arr = new int[arrCnt];

        for (int i = 0; i < arrCnt; i++) {
            arr[i] = scanner.nextInt();
        }

        sorting(arr.clone()); // 정렬 알고리즘
        sortingMethod(arr.clone()); // 정렬 라이브러리
    }

    private static void sortingMethod(int[] arr) {

        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, Comparator.reverseOrder());

        for (int elm :
                integerArr) {
            System.out.print(elm);
            System.out.print(", ");
        }
    }

    private static void sorting(int[] arr){

        int [] arr1 = arr;
        int max;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(max < arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    max = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
