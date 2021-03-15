package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class KruskalEx01 {
    // 크루스칼 알고리즘 기본 코드

    public static void main(String[] args) throws IOException {
        /**
         * 모든 간선을 담을 배열 - edges
         * 최종 비용을 담을 변수 - result
         * 부모 노드 테이블 - parent
         *
         * 노드의 개수 - v
         * 간선의 개수 - e
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList(v);
        int[] parent = new int[v + 1];
        int result = 0;

        // 부모 노드 테이블에서, 부모를 자기 자신으로 초기화 한다.
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
            System.out.println(Arrays.toString(parent));
        }

        // 모든 간선 정보 입력받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(weight, a, b));
        }

        // edges 정렬
        Collections.sort(edges);
        for (Edge edge : edges) { // 모든 간선을 하나씩 확인하며
            int cost = edge.weight;
            int a = edge.a;
            int b = edge.b;

            System.out.println("cost = " + cost);

            // 싸이클이 발생하지 않는 경우에만 집합에 포함
            if(find_parent(parent, a) != find_parent(parent, b)){
                union_parent(parent, a, b);
                result += cost;
            }
        }
        System.out.println("result = " + result);
    }

    // 두 원소가 속한 집합찾기
    private static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
        System.out.println(Arrays.toString(parent));
    }

    private static int find_parent(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if(parent[x] != x){
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }
}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int weight;

    public Edge(int cost, int a, int b){
        this.weight = cost;
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight,  o.weight);
    }

}
