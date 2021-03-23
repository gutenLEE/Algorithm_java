package com.algorithm.Sort;

import java.util.Scanner;
class BubbleSortEx01 {
    public static void main(String []args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of integers to sort");
        n = in.nextInt();

        int array[] = new int[n];

        System.out.println("Enter " + n + " integers");

        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();

        // 버블 정렬 시작
        for (int i = 0; i < n - 1; i++) {
            Boolean swapped = false;
            System.out.print("탐색할 인덱스 ");
            for (int j = 0; j < n - i - 1; j++) {

                System.out.print(" "+ j + " ");
                if (array[j] > array[j+1]) /* For descending order use < */
                {
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;

                    swapped = true;
                }
            } // 내부 반복문
            System.out.println();
            if(!swapped)
                break;
        } // 외부 반복문
        System.out.println("Sorted list of numbers:");
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }
}