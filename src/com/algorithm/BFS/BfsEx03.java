package com.algorithm.BFS;

// https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsEx03 {

    static int row;
    static int col;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String strRow = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(strRow.charAt(j) + "");
            }
        }

        bfs(0, 0);
        System.out.println(map[row - 1][col - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!que.isEmpty()){
            Node node = que.poll();

            for (int i = 0; i < dx.length; i++) {
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];

                // map 영역 내 데이터 검사
                if(tmpX < 0 || tmpX >= row || tmpY < 0|| tmpY >= col){
                    continue;
                }

                if(map[tmpX][tmpY] == 0)
                    continue;

                // 상하좌우 중 이동할 좌표가 있으면 큐에 추가
                if(map[tmpX][tmpY] == 1){
                    // 이동 횟추 추가 +1
                    map[tmpX][tmpY] = map[node.x][node.y] + 1;
                    que.add(new Node(tmpX, tmpY));
                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
