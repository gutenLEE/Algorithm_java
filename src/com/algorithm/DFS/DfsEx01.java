package com.algorithm.DFS;
import java.io.IOException;
import java.util.*;

public class DfsEx01 {
    /*
     DFS : Depth-Fisrt Search
           깊이 우선 탐색. 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘

     언제 사용하나?
            모든 노드를 방문하고자 할 때. 완전 탐색 알고리즘에 자주 사용된다.

     특징
        - 자기 자신을 호출하는 순회 알고리즘 형태
        - 노드 방문여부를 반드시 검사해야 한다.

     구현 방법
        - 재귀
        - 스택
     */

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt(); //노드 개수
        int edges = scanner.nextInt(); // 간선 개수
        int vertex = scanner.nextInt(); // 탐색을 시작할 정점

        boolean visited[] = new boolean[nodes + 1]; // 노드 방문 여부 검사 배열

        // 인접 리스트로 구현하기
        LinkedList<Integer>[] adjList = new LinkedList[nodes + 1];

        for(int i = 0; i <= nodes; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i <= edges; i++){
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            adjList[vertex1].add(vertex2);
            adjList[vertex2].add(vertex1);
        }
        for(int i = 0; i <= nodes; i++) {
            Collections.sort(adjList[i]);
        }
    }
    public static void dfs(int vertex, LinkedList<Integer>[] adjList, boolean[] visited){
        // 노드 방문
        visited[vertex] = true;

        Iterator<Integer> iter = adjList[vertex].listIterator();
        while (iter.hasNext()){
            int w = iter.next();
            if(!visited[w])
                dfs(w, adjList, visited);
        }
    }
}
