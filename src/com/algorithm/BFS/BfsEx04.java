package com.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BfsEx04 {
    static int row;
    static int col;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        while(true){
            if(!isExit()) break;
            drawMap();
            chkMine();
            print();
        }
    }

    private static void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void chkMine() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == '*')
                    addCount(i, j);
            }
        }
    }

    private static void addCount(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if(i < 0 || i >= row) continue;
                if(j < 0 || j >= col) continue;
                if(map[i][j] == '*') continue;
                map[i][j]++;
            }
        }
    }

    private static void drawMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = (line.charAt(j) == '.') ? '0' : '*';
            }
        }
    }

    private static boolean isExit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        if(row == 0 && col == 0) return false;
        return true;
    }
}
