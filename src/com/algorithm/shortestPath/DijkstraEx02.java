package com.algorithm.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkstraEx02 {

    static int n; // 노드 개수
    static int m; // 간선 개수

    static int[] distance; // 가중치 저장
    static boolean[] visit; // 방문 여부 저장
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드
        m = Integer.parseInt(st.nextToken()); //간선

        int start = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        graph = new ArrayList[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            System.out.println("n " + n + " m " + m);
            st = new StringTokenizer(br.readLine());

            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            graph[begin].add(new Node(end, dis));

        }

        dijkstraQueue(start);
        System.out.println(Arrays.toString(distance));
    }

    static void dijkstraQueue(int start){
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()){

            Node curr = pq.poll();

            int node = curr.end;
            int dist = curr.distance;

            if(distance[node] < dist){
                continue;
            }

            for (Node next : graph[node]) {

                int nextNode = next.end;
                int nDist = next.distance;

                if(distance[nextNode] > distance[node] + nDist){
                    distance[nextNode] = distance[node] + nDist;
                    pq.offer(new Node(nextNode, dist));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{

        int end;
        int distance;

        Node(int end, int distance){
            this.end = end;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }

        public String toString() {
            return "end " + end + " : distance " + distance;
        }
    }

}

