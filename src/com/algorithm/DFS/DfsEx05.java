package com.algorithm.DFS;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2667
public class DfsEx05 {
    static int area = 0;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String strRow = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strRow.charAt(j) + "");
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dfs(i, j, map, visit) == true){
                    cnt++;
                    arr.add(area);
                    area = 0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(arr);
        for (Integer i: arr) {
            System.out.println(i);
        }
    }
    public static boolean dfs(int x, int y, int[][] map, boolean[][] visit){
        // 매개변수 검사
        if(x < 0 || x >= map.length || y < 0 || y >= map.length){
            return false;
        }

        if(map[x][y] == 1 && !visit[x][y]){
            visit[x][y] = true;
            area++;
            dfs(x - 1, y, map, visit);
            dfs(x + 1, y, map, visit);
            dfs(x, y - 1, map, visit);
            dfs(x, y + 1, map, visit);

            return true;
        }
        return false;
    }

    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
