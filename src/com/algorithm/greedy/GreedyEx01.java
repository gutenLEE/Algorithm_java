package com.algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyEx01 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력받을 숫자의 갯수
        int M = Integer.parseInt(st.nextToken()); // 더할 횟수
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[arr.length - 1];
        int second = arr[arr.length - 2];
        int result = 0;
        int count = 0;

        for(int i = 0; i < M; i++){

            if(count < K){
                result += first;
                count++;
            }
            else{
                result += second;
                count = 0;
            }
        }

        System.out.println(result);


    }
}
