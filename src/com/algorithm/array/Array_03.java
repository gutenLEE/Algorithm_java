package com.algorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.StringTokenizer;

/**
 * 숫자의 개수
 *
 * @author yhlee
 * @created_at 2021-08-19 오후 11:42
 */
public class Array_03 {
    public static void main(String[] args) throws IOException {
        // 150 × 266 × 427 = 17037300
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s3 = st.nextToken();

        Long res = Long.parseLong(s) * Long.parseLong(s2) * Long.parseLong(s3);
        String str = Long.toString(res);

        int len = str.length();
        int[] arr = new int[10];

        for (int i = 0; i < len; i++) {
            int idx = Character.getNumericValue(str.charAt(i));
            arr[idx]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
