package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mine {
    static private char[][] map;
    static int row = 0;
    static int col = 0;
    static int iteration = 0;

    public static void main(String[] args) throws IOException {

        loadMap();
        calculateMap();
        print();
    }

    private static void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void calculateMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == '*')
                    addCountAround(i, j);
            }
        }
    }

    private static void addCountAround(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                addCount(i, j);
            }
        }
    }

    private static void addCount(int x, int y) {
        if(x < 0 || x >= row) return;
        if(y < 0 || y >= col) return;
        if(map[x][y] == '*') return;
        map[x][y]++;
    }

    private static void loadMap() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == '.')
                    map[i][j] = '0';
            }
        }
    }


}
