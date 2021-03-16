package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KruskalEx02 {
    /**
     * 집의 개수 - n
     * 길의 개수 - m
     *
     * 가중치(유지비용) 저장 배열 -
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<House> houses = new ArrayList(m);
        int[] parent = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 연결 정보 저장
            houses.add(new House(a, b, cost));
        }
        // 비용 오름차순 정렬
        Collections.sort(houses);
        int result = 0;
        int last = 0;
        for (House house : houses) {
            int a = house.a;
            int b = house.b;
            int cost = house.cost;

            if (find_parent(parent, a) != find_parent(parent, b)) {
                connect(parent, a, b);
                result += cost;
                last = cost;
                System.out.println("last = " + last);
            }
        }
        System.out.println(result - last);
    }

    private static void connect(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;

    }

    private static int find_parent(int[] parent, int x) {

        if(parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }

}
class House implements Comparable<House>{
    int a;
    int b;
    int cost;

    House(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(House o) {
        return Integer.compare(this.cost, o.cost);
    }
}