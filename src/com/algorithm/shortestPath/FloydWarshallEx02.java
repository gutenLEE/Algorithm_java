package com.algorithm.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshallEx02 {
    public static void main(String[] args) throws IOException {
        /**
         * 연결 정보 저장 리스트 - graph[][]
         * 회사의 개수 - N
         * 경로의 개수 = V
         * 경유지 - orderBy
         * 목적지 - dest
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int[][] graph = new int [N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if(i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 100001;
            }
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], 1);
            graph[b][a] = Math.min(graph[b][a], 1);
        }

        for (int k = 1; k < N + 1; k++) {
            for (int a = 1; a < N + 1; a++) {
                for (int b = 1; b < N + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int dest = Integer.parseInt(st.nextToken()); // 경유지
        int dropBy = Integer.parseInt(st.nextToken()); // 목적지

        int distance = graph[1][dropBy] + graph[dropBy][dest];

        if(distance < Integer.MAX_VALUE)
            System.out.println(distance);
        else
            System.out.println(-1);

    }
}
