package com.algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class DijkstraEx01 {
    static int n; // 노드 개수
    static int m; // 간선 개수

    static int[] distance; // 가중치 저장
    static boolean[] visit; // 방문 여부 저장
    static List<int[]>[] graph; // 간선, 가중치 저장

    public static void main(String[] args) throws IOException {
        // 가장 빠른 길 찾기

        int max = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드
        m = Integer.parseInt(st.nextToken()); //간선
        int start = Integer.parseInt(st.nextToken()); //시작 노드

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        visit = new boolean[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()); // a : node와 연결된 노드
            int b = Integer.parseInt(st.nextToken()); // b로 가는 비용

            graph[node].add(new int[]{a, b});
        }

        dijkstra(start);

        for (int i : distance) {
            if(i == Integer.MAX_VALUE)
                System.out.println("inf");
            else
                System.out.println(i);
        }
    }
    public static int getSmallestNode(){
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 1; i < n + 1; i++) {
            if(distance[i] < min && !visit[i]){
                min = distance[i];
                idx = i;
            }
            System.out.println(Arrays.toString(distance));
        }
        return idx;
    }

    public static void dijkstra(int start){
        // 시작 노드에 대해서 초기화
        distance[start] = 0;
        visit[start] = true;
        List<int[]> info = graph[start];
        Iterator iterator = info.iterator();

        while(iterator.hasNext()){
            int[] v = (int[]) iterator.next();
            distance[v[0]] = v[1]; //[0] : 노드, [1] : 거리

            System.out.println(Arrays.toString(v));
        }

        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visit[now] = true;

            int vertexSIZE = graph[now].size();
            for (int j = 0; j < vertexSIZE; j++) {
                int cost = distance[now] + graph[now].get(j)[1];

                if(cost < distance[graph[now].get(j)[0]])
                    distance[graph[now].get(j)[0]] = cost;
            }
        }
    }
}
