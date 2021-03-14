package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSetEx01 {
    // 서로소 집합 알고리즘
    public static void main(String[] args) throws IOException {
        /**
         * 노드의 개수 - n
         * 간선의 개수 = edge
         * 테이블 - tree
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int edge = Integer.parseInt(st.nextToken()); // 간선의 개수
        int[] parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) { // 부모 테이블에서 부모를 자기 자신으로 초기화
            parent[i] = i;
        }

        // union 연산 각각 수행
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            getUnion_parent(parent, a, b);
        }

        // 각 원소가 속한 집합 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.print(find_parent(parent, i) + " ");
        }
        System.out.println();

        //부모 테이블 내용 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.print(parent[i] +  " ");
        }

    }

    // 두 원소가 속한 집합을 합치기
    private static void getUnion_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    private static int find_parent(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if(parent[x] != x)
                parent[x] = find_parent(parent, parent[x]);
            //return find_parent(parent, parent[x]);
        return parent[x];

    }
}
