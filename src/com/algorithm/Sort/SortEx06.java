package com.algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class SortEx06 {
    public static void main(String[] args) throws IOException {
        // 이.코 - 성적이 낮은 순서로 학생 출력하기 181p

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int students = Integer.parseInt(st.nextToken()); // 학생 수

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        int score; // 점수
        String name;

        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            score = Integer.parseInt(st.nextToken());

            if(map.get(score) == null) {
                map.put(score, new ArrayList<>());
                map.get(score).add(name);
            }
            else{
                map.get(score).add(name);
            }
        }

        for (int i = 100; i > 0; i--) {
            if(map.containsKey(i)){
                for (int j = 0; j < map.get(i).size(); j++) {
                    System.out.printf("%s %d", map.get(i).get(j), i);
                    System.out.println();
                }
            }
        }
    }
}
