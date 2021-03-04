package com.algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SearchEx02 {
    public static void main(String[] args) throws IOException {
        //이.코 - 부품

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] products;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        products = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            products[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(products);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int res = binarySearching(0, products.length - 1, products, target);

            if (res == 1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
    private static int binarySearching(int start, int end, int[] products, int target){

        // 매개변수 값 검사
        if(start > end)
            return -1;

        int mid = (start + end) / 2;

        if(target == products[mid])
            return 1;
        else if(target < products[mid])
            return binarySearching(start, mid - 1, products, target);
        else
            return binarySearching(mid + 1, end, products, target);
    }
}
