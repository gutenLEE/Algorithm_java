package com.algorithm.implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplEx02 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hour = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < hour + 1; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    String h = Integer.toString(i);
                    String m = Integer.toString(j);
                    String s = Integer.toString(k);

                    if((h+m+s).contains("3")){
                        count += 1;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
