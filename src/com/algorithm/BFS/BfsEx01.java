package com.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BfsEx01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner scan = new Scanner(System.in);

        int nodes = Integer.parseInt(st.nextToken()); // 노드 수
        int edges = Integer.parseInt(st.nextToken()); // 간선 수
        int start = Integer.parseInt(st.nextToken()); // 현재 위치

        boolean visited[] = new boolean[nodes + 1];

        LinkedList<Integer>[] ajdList = new LinkedList[nodes + 1];

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());


        }
    }
}
