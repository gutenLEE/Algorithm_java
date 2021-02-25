package com.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DfsEx03_1 {
    public static void main(String[] args) throws IOException {
        // 백준 1260번 - DFS와 BFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner scan = new Scanner(System.in);

        int nodes = Integer.parseInt(st.nextToken()); // 노드 수
        int edges = Integer.parseInt(st.nextToken()); // 간선 수
        int start = Integer.parseInt(st.nextToken()); // 현재 위치
        int [][] map = new int[nodes + 1][ nodes + 1];
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }

        dfsArr(start, map, visited);

    }
    public static void dfsArr(int start, int[][] map, boolean[] visit){
        visit[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < map.length; i++) {
            if(map[start][i] == 1 && !visit[i]){
                dfsArr(i, map, visit);
            }
        }

    }
}
