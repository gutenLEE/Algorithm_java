package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TopologySortEx02 {
    /**
     * 커리큘럼
     *
     * 요구사항
     * 1. N개의 강의에 대하여 수강하기까지 걸리는 최소 시간
     * 2. 강의 마다 먼저 들어야 하는 선수 강의가 있을 수 있다.
     *
     * 입력
     * 듣고자 하는 강의 개수 - n
     * 강의 시간과 선수 강의 시간들
     * -1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1]; // 진입 차수 저장 배열
        Arrays.fill(indegree, 0); // 0으로 초기화
        ArrayList[] graph = new ArrayList[n + 1]; //


    }
}
