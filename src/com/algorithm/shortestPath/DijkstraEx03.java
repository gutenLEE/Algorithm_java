package com.algorithm.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraEx03 {
    // 전보

    public static void main(String[] args) throws IOException {
        /**
         * 도시의 개수 - N
         * 통로의 개수 - V
         * 메세지 보내는 도시 - city
         * 도시 연결, 가중치 정보 - graph
         * 가중치 갱신 테이블 - distance
         */

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        /**
         * 요구 사항
         * city에서 보낸 메세지를 받게 되는 도시의 개수와 시간
         */
        PriorityQueue<Edge>pq = new PriorityQueue(); // 우선순위 큐

        pq.offer(new Edge(city, 0));
        distance[city] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currN = curr.end;
            int currDist = curr.weight;

            if(distance[currN] < currDist) continue;

            for (Edge node : graph[currN]) {
                int cost = currDist + node.weight; // 현재 노드를 거쳐서 인접 노드로 갈때 가중치
                int adjNode = node.end;

                if(cost < distance[adjNode]) { // 현재 노드를 거쳐서 인접 노드로 가는 가중치와 기존의 가중치 값을 비교
                    // 현재 노드를 거쳐서 가는 가중치가 더 작으면 가중치 배열 갱신
                    distance[adjNode] = cost;
                    pq.offer(new Edge(adjNode, cost));
                }
            }
        }

        int count = 0;
        int maxDist = 0;
        System.out.println(Arrays.toString(distance));
        for (int dist:distance) {
            if (dist != Integer.MAX_VALUE){
                count++;
                maxDist = Math.max(maxDist, dist);
            }
        }

        System.out.println(count - 1 + " " + maxDist);

    }

}

class Edge implements Comparable<Edge>{
    int end;
    int weight;

    public Edge(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight,  o.weight);
    }
}
