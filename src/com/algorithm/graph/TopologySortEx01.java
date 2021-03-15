package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySortEx01 {
    public static void main(String[] args) throws IOException {
        /**
         * 노드 개수 - v
         * 간선 개수 - e
         * 진입 차수 저장 배열 - indegree
         * 간선 정보 - graph
         * 큐 = queue
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] indegree = new int[v + 1];
        Arrays.fill(indegree, 0);
        ArrayList[] graph = new ArrayList[v + 1];

        for (int i = 1; i < v + 1; i++) {
            graph[i] = new ArrayList();
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); // a -> b
            indegree[b] += 1; // 진입차수 1 증가
        }

        topologySort(graph, indegree, v);

    }

    private static void topologySort(ArrayList[] graph, int[] indegree, int v) {

        ArrayList result = new ArrayList();
        Queue queue = new LinkedList();

        for (int i = 1; i < v + 1; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {

            // 큐에서 원소 꺼내기
            int now = (int) queue.poll();
            result.add(now);

            // 해당 노드와 연결된 노드들의 진입차수에서 1 빼기
            for (Object node : graph[now]) {
                indegree[(int)node] -= 1;
                //새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[(int) node] == 0) {
                    queue.offer((int) node);
                }
            }
        }
        // 위상 정렬 결과 출력
        Iterator iter = result.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}
