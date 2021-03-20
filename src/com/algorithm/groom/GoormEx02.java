package com.algorithm.groom;

import java.io.*;
import java.util.StringTokenizer;

class GoormEx02 {
	// 여름의 대삼각형
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] pos = new int[3][2];
		for(int i = 0; i < 3; i++){
			st = new StringTokenizer(br.readLine());

			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		// 예외 처리 how?
		double res = Math.abs(((pos[0][0] * pos[1][0]) + (pos[1][0] * pos[2][0]) + (pos[2][0] * pos[0][0])) * 0.5);

		System.out.printf("%.2f", res);
	}
}