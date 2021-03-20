package com.algorithm.groom;

import java.io.*;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);

        double sum = 0;
        for(int i = 0; i <= num; i++){
            sum += Math.pow(i, 2);
        }
        DecimalFormat df=new DecimalFormat("#.##");

        System.out.print(df.format(sum));
    }
}