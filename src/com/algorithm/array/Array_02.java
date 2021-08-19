package com.algorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 2차원 배열의 합
 *
 * @author yhlee
 * @created_at 2021-08-16 오전 10:25
 */
public class Array_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m]; // 2차원 배열 생성

        // matrix 입력하기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 좌표
        st = new StringTokenizer(br.readLine());
        int lines = Integer.parseInt(st.nextToken());
        for (int i = 0; i < lines; i++) { // lines 수 만큼 반복
            String s = br.readLine();
            String[] pos = s.split(" ");
            int x1 = Integer.parseInt(pos[0]) - 1;
            int y1 = Integer.parseInt(pos[1]) - 1;
            int x2 = Integer.parseInt(pos[2]) - 1;
            int y2 = Integer.parseInt(pos[3]) - 1;

            int result = 0;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    result += matrix[j][k];
                }
            }
            System.out.println(result);
        }
    }
}
