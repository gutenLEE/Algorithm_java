package com.algorithm.DFS;

import java.util.Scanner;
import java.util.Stack;

public class DfsEx02 {
    public static void main(String[] args) {
        // 2차원 배열에 정점과 간선을 넣어 인접행렬을 만든다.
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt(); //노드 개수
        int edges = scanner.nextInt(); // 간선 개수
        int vertex = scanner.nextInt(); // 탐색을 시작할 정점

        boolean visited[] = new boolean[nodes + 1]; // 노드 방문 여부 검사 배열

        int[][] adjArr = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            adjArr[vertex1][vertex2] = 1;
            adjArr[vertex2][vertex1] = 1;
        }

        dfsArr(vertex, adjArr, visited);

    }
    public static void dfsArr(int vertex, int[][] adjArr, boolean[] visited){
        int i = adjArr.length - 1;
        visited[vertex] = true;

        for(int j = 0; j <= i; j++){
            if(adjArr[vertex][i] == 1 && !visited[i])
                dfsArr(vertex, adjArr, visited);
        }
    }
    public static void dfsStack(int vertex, int[][] adjArr, boolean[]visited, boolean flag){
        int i = adjArr.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(vertex);
        visited[vertex] = true;

        while(!stack.isEmpty()){
            int w = stack.peek();
            flag = false;

            for(int j = 1; j < i; j++){
                if(adjArr[w][j] == 1 && !visited[j]){
                    stack.push(j);
                    visited[j] = true;
                    flag = true;

                    break;
                }
            }
            if(!flag){
                stack.pop();
            }
        }
    }
}
