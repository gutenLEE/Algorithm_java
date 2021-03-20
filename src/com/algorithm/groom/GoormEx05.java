package com.algorithm.groom;

import java.io.*;
import java.util.*;

class GoormEx05 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int num = Integer.parseInt(input);

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList list = new ArrayList();

        for(int i = 0; i < num; i++){

            int n = Integer.parseInt(st.nextToken());
            if((n & (n - 1)) != 0){
                list.add(i);
            }
        }
        // output
        if(list.size() == 0) {
            System.out.println(0);
        }
        else{
            System.out.println(list.size());
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                System.out.print(((int)iter.next() + 1) + " ");
            }
        }
    }
}