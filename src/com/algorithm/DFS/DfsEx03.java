package com.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DfsEx03 {
    public static void main(String[] args) throws IOException {
        // 백준 1260, DFS와 BFS

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner scan = new Scanner(System.in);

        int nodes = Integer.parseInt(st.nextToken()); // 노드 수
        int edges = Integer.parseInt(st.nextToken()); // 간선 수
        int start = Integer.parseInt(st.nextToken()); // 현재 위치
        boolean visit[] = new boolean[nodes + 1]; // 방문 여부 저장할 배열 선언

        // 인접 리스트로 구현하기
        LinkedList<Integer>[] adjList = new LinkedList[nodes + 1];

        for(int i = 0; i <= nodes; i++){
            adjList[i] = new LinkedList<>();
        }

        int v1, v2; // 간선을 연결하는 두 정점
        for(int j = 0; j < edges; j++){

            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            // 간선에 연결된 두 노드 정보 입력
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        // 정렬
        for (int i = 1; i < nodes + 1; i++) {
            Collections.sort(adjList[i]);
        }
        // DFS 시작
        dfs(start, adjList, visit);
    }

    private static void dfs(int start, LinkedList<Integer>[] adjList, boolean[] visit) {
        // 1. 방문 처리
        visit[start] = true;
        System.out.print(start + " ");
        System.out.println("LinkedList : " + adjList[start]);
        // 2. 방문할 곳이 없을때까지 노드 탐색
        Iterator<Integer> iter = adjList[start].listIterator();

        while(iter.hasNext()){
            int tmp = iter.next();
            // tmp 노드에 방문했던 적이 없다면 또 탐색 시작
            if(!visit[tmp]){
                dfs(tmp, adjList, visit);
            }
        }
    }
}
