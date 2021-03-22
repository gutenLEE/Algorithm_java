package com.java.CoTe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CafeEx03 {
    static private char[][] map;
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) throws IOException {


        initMap();
        chkMine();
        printMap();
    }

    private static void printMap() {
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
                isNotMine(i, j);
            }
        }
    }

    private static void isNotMine(int x, int y) {
        if(x < 0 || x >= row) return;
        if(y < 0 || y >= col) return;
        if(map[x][y] == '*') return;
        map[x][y]++;
    }

    private static void initMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        for (int i = 0; i < row; i++) {

            String line = br.readLine();

            for (int j = 0; j < col; j++) {
                map[i][j] = (line.charAt(j) == '.') ? '0' : '*';
            }
        }
    }
}
