package com.algorithm.groom;

import java.util.Scanner;

public class amusementPark {
    public static final Scanner scanner = new Scanner(System.in);
    public static int min = 0;

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                search(i, j, N, K);
            }
        }
        int answer = Integer.MAX_VALUE;
        System.out.println(answer);
    }

    public static void search(int a, int b, int N, int K){

        int dx = a + K;
        int dy = b + K;
        int trash = 0;

        if(dx >= N || dx < 0 || dy >= N || dy < 0){
        }
        else{
            for (int i = a; i < dx; i++) {
                for (int j = b; j < dy; j++) {

                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}