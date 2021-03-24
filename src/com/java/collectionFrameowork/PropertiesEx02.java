package com.java.collectionFrameowork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx02 {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("USAGE: java PropertiesEx2 INPUTFILENAME");
            System.exit(0);
        }


        Properties properties = new Properties();

        String inputFile = args[0];

        try{
            properties.load(new FileInputStream((inputFile)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = properties.getProperty("name");
        String[] data = properties.getProperty("Data").split(",");

        int max = 0, min = 0;
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            int intValue = Integer.parseInt(data[i]);

            if(i == 0) max = min = intValue;

            if(max < intValue)
                max = intValue;
            else if(min > intValue)
                min = intValue;
            sum += intValue;
        }
        System.out.println("name = " + name);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("sum = " + sum);
        System.out.println("(sum*100.0/data.lent) = " + (sum * 100.0 / data.length)/100);
    }
}
