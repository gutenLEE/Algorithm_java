package com.algorithm.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class GoormEx06 {
    // 진법변환
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long origin = Long.parseLong(st.nextToken());
        String after = st.nextToken();

        for (int i = 2; i < 17; i++) {
            String originToAfter = conversion(origin, i);
            System.out.println("originToAfter = " + originToAfter);
            if (after.equals(originToAfter)){
                System.out.println(i);
                break;
            }
        }
    }


    public static String conversion(long num, int after){
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack<>();
        long current = num;

        while(current > 0){
            if (current % after < 10) {
                stack.push(current % after);
                //sb.append((char) (current % after));
            } else {
                stack.push((char)(current % after -10 + 'A'));
                //sb.append((char)(current % after - 10 + 'A'));
            }
            current /= after;
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
