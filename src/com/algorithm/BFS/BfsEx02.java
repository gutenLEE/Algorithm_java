package com.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 이.코 - 미로탈출 152페이지
public class BfsEx02 {
    static BufferedReader br;
    static StringTokenizer st;

    static int row;
    static int col;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        inputMap();
        bfs(0, 0);
    }

    private static void bfs(int x, int y) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] xy;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});

        while (!que.isEmpty()){

            xy = que.poll();

            for (int i = 0; i < dx.length; i++) {

                int tmpX = xy[0] + dx[i];
                int tmpY = xy[1] + dy[i];

                // map 범위 내 위치 검사
                if(tmpX <= -1 || tmpX >= row || tmpY <= -1 || tmpY >= col){
                    continue;
                }

                // 괴물(0)인 경우 무시
                if(map[tmpX][tmpY] == 0)
                    continue;
                // 1 : 통로, 처음 방문 한 경우만 수행 if(map[][] == 1)
                if(map[tmpX][tmpY] == 1) {
                    map[tmpX][tmpY] = map[x][y] + 1;
                    que.add(new int[] {tmpX, tmpY});
                }
            }
        }

        System.out.println(map[row - 1][col - 1]);


    }

    public static void inputMap() throws IOException {
        for (int i = 0; i < row; i++) {
            String rowStr = br.readLine();

            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(rowStr.charAt(j) + "");
            }
        }
    }
}
