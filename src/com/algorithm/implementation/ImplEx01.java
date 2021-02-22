package com.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImplEx01 {
    public static void main(String[] args) throws IOException {
        // 이것이 코딩테스트다 - 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xy = {1, 1};
        int[] tmp = {1, 1};
        int [] dx = {0, 0, -1, 1};
        int [] dy = {-1, 1, 0, 0};
        char[] directions = {'L', 'R', 'U', 'D'};

        while (st.hasMoreTokens()){
          char direction = st.nextToken().charAt(0);

          for(int i = 0; i < 4; i++){
              if(directions[i] == direction){
                  tmp[0] = xy[0] + dx[i];
                  tmp[1] = xy[1] + dy[i];
              }
          }
          if(tmp[0] < 1 || tmp[1] < 1 || tmp[0] > n || tmp[1] > n)
            continue;
          xy[0] = tmp[0];
          xy[1] = tmp[1];
        }
    }
}
