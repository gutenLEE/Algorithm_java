package com.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이.코 - 음료수 얼려 먹기 149p
public class DfsEX04 {

    static int row;
    static int col;
    static int[][]map;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        inputMap(row, col); // map 만들기

        // 탐색 메서드 호출
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(i, j) == true){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void inputMap(int row, int col) throws IOException {
        map = new int[row][col];

        // 얼음틀 데이터 2차원 배열에 입력하기
        for (int i = 0; i < row; i++) {
            String rowStr = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(rowStr.charAt(j) + "");
            }
        }
    }
    // 탐색 메서드
    public static boolean dfs(int r, int c){
        // 매개변수 유효성 검사
        if(r <= -1 || r >= row || c <= -1 || c >= col){
            return false;
        }
        if(map[r][c] == 0 ){
            // 0 -> 1
            map[r][c] = 1;

            // 상하좌우 탐색
            dfs(r - 1, c); // 상
            dfs(r + 1, c); // 하
            dfs(r, c - 1); // 좌
            dfs(r, c + 1); // 우
            return true;
        }
        return false;
    }


}
