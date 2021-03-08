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
        int start = Integer.parseInt(st.nextToken()); //시작 노드

        distance = new int[n + 1];
        graph = new ArrayList[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[begin].add(new Node(end, Integer.parseInt(st.nextToken())));
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
            int currNode = curr.end;
            int currDist = curr.distance;

            if(distance[currNode] < currDist){
                continue;
            }
            int adjSize = graph[currNode].size();
            ArrayList<Node> node = graph[currNode];
            for (int i = 0; i < adjSize; i++) {

                int dist = node.get(i).distance;
                int now = node.get(i).end;

                if(distance[now] < dist){
                    continue;
                }

                for (Node next : graph[now]) {
                    int cost = dist + next.distance;

                    if(cost < distance[next.end]){
                        distance[next.end] = cost;
                        pq.offer(new Node(cost, next.end));
                    }
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
    }

}

