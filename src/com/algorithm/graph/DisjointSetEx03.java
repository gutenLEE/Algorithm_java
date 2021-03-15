package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

import static javax.management.ImmutableDescriptor.union;

public class DisjointSetEx03 {

    // 팀 결성
    public static void main(String[] args) throws IOException {
        /**
         * 학생 수 - n
         * 연산 횟수 - m
         * 루트 배열 - parent
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) { // union
                unionTeam(parent, a, b);
            }
            else{ // find_parent
                if (find_parent(parent, a) == find_parent(parent, b)) {
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
        }
    }

    private static void unionTeam(int[] parent, int a, int b) {

        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    private static int find_parent(int[] parent, int x) {
        if(parent[x] != x){
            find_parent(parent, parent[x]);
        }
        return parent[x];
    }
}
