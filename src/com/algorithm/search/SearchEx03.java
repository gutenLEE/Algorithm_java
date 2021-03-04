package com.algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SearchEx03 {
    static int result = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] sticks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sticks);
        int res = binarySearch(sticks[0], sticks[sticks.length - 1], sticks);

        if(res != -1)
            System.out.println(res);

    }
    private static int binarySearch(int min, int max, int[] arr){
        int mid = (min + max) / 2;

        if(min < max)
            return -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - mid > 0)
                result += arr[i] - mid;
        }

        if(result == m)
            return mid;
        else if(result > m)
            return binarySearch(mid, max, arr);
        else if(result < m)
            return binarySearch(min, mid, arr);

        return -1;
    }
}
