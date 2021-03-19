package com.algorithm.groom;

import java.io.*;
import java.util.*;

// 고장난 컴퓨터
class GoormEx01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int coolTime = Integer.parseInt(st.nextToken());
        //System.out.println("cool time " + coolTime);

        Stack stack = new Stack();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(!stack.isEmpty()){
                if((num - (int)stack.peek()) > coolTime){
                    stack.clear();
                }
            }
            stack.add(num);
            //System.out.print(stack);
        }
        System.out.print(stack.size());
    }
}