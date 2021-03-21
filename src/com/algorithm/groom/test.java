package com.algorithm.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int origin = Integer.parseInt(st.nextToken());
        String after = st.nextToken();

        for (int i = 2; i < 17; i++) {
            Stack stack = new Stack<>();
            int num = origin;
            while(num / i != 0){
                stack.push(num % i);
                num = num / i;
            }
            if(num / i != 1){
                stack.push(num % i);
            }
            String n = "";
            while(!stack.isEmpty()){
                n += Integer.toString((Integer) stack.pop());
                //n.concat(Integer.toString((Integer) stack.pop())); => 왜 안되는 것?
            }
            System.out.println("n = " + n);
            if (after.equals(n)) {
                System.out.println(i);
                break;
            }

        }
    }
}
