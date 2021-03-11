package com.algorithm.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class floydWarshallEx01 {
    public static void main(String[] args) throws IOException {

        final int INF = 100001;

        /**
         * 필요한 변수
         * 노드 비용 갱신 테이블 - 2차원 배열 : graph
         * 노드 수 - n
         * 간선 수 = v
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];

        // 그래프 배열 원소들 무한으로 초기화
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 0; i < n + 1; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], cost);
            //graph[a][b] = cost;
            //System.out.println(Arrays.toString(graph[a]));
        }

        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if(graph[i][j] == INF)
                    System.out.print("0");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
