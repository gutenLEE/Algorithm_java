package com.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DfsEx06 {

    static LinkedList<Integer>[] adjList;
    static boolean[] visit;
    static int call = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        visit = new boolean[nodes + 1];
        adjList = new LinkedList[nodes + 1];

        for (int i = 0; i < nodes + 1; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        dfs(1);
        System.out.println(call - 1);
    }

    public static void dfs(int start){
        // 노드 방문
        visit[start] = true;
        call++;

        Iterator<Integer> iter = adjList[start].listIterator();
        while (iter.hasNext()){
            int w = iter.next();
            if(!visit[w]){
                System.out.println(w);
                dfs(w);
            }

        }

    }
}
