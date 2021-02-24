package com.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImplEx04 {

    static int[][] map;
    static boolean[][] visit;
    static int dir;
    static int row;
    static int col;

    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map size
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapR = Integer.parseInt(st.nextToken());
        int mapC = Integer.parseInt(st.nextToken());

        map = new int[mapR][mapC];
        visit = new boolean[mapR][mapC];

        // location, dir
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        // 현재 위치 상태 변경
        visit[row][col] = true;

        // map
        for(int i = 0; i < mapR; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < mapC; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int visitCnt = 1;

        while(true){
            // 회전
            turn();

            // 이동(0 : 육지, 1 : 바다)
            // 육지인 경우
            if((map[row + dirR[dir]][col + dirC[dir]] == 0) &&
                    (visit[row + dirR[dir]][col + dirC[dir]]) == false)
            {
                visit[row + dirR[dir]][col + dirC[dir]] = true;
                visitCnt++;

                // 위치 변경
                row += dirR[dir];
                col += dirC[dir];

                cnt = 0;
            }
            // 바다인 경우
            else{
                cnt++;
            }
            // 사면이 모두 이동할 수 없는 경우
            if(cnt == 4){
              // back 할 수 없는 경우
                if(map[row - dirR[dir]][col - dirC[dir]] == 1)
                    break;
              // back
                else{
                    cnt = 0;
                    row -= dirR[dir];
                    col -= dirC[dir];
                }
            }
        }
        System.out.println(visitCnt);

    }
    // 회전 후 방향
    static void turn(){
        dir -= 1;
        if(dir < 0)
            dir = 3;
    }
}
