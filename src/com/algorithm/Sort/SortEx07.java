package com.algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortEx07 {

    public static void main(String[] args) throws IOException {
        // 두 배열의 원소 교체

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] asc = new Integer[n];
        Integer[] dsc = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            asc[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dsc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(asc);
        Arrays.sort(dsc, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            // 교체 조건!!!!
            if(asc[i] < dsc[i])
                asc[i] = dsc[i];
        }

        int sum = 0;
        for (int elm : asc) {
            sum += elm;
        }
        System.out.println(sum);

    }

}
