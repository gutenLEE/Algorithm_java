package com.algorithm.search;

import java.util.Arrays;

public class SearchEx01 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 9, 15, 17, 18, 21, 23, 23, 30, 31, 31, 34, 40, 48};

        int res = binarySearch(arr, 0, arr.length-1, 2);
        if(res != -1)
            System.out.println(res + 1 + "번 위치에 있다. 반복문");

        int res2 = binarySearchRecursion(arr, 0, arr.length - 1, 9);
        //if(res2 != -1)
        System.out.println(res2 + 1 + "번 위치에 있다. 재귀");

    }

    private static int binarySearchRecursion(int[] arr, int start, int end, int target) {

        if(start > end)
            return -1;
        int mid = (start + end) / 2;
        if(target == arr[mid])
            return mid;
        else if(target < arr[mid]){
            return binarySearchRecursion(arr, start, mid - 1, target);
        }
        else
            return binarySearchRecursion(arr, mid + 1, end, target);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;

            if(target == arr[mid])
                return mid;
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return - 1;
    }



}
