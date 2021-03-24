package com.java;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx01 {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("timeout", "30");
        properties.setProperty("language", "kr");
        properties.setProperty("size", "10");
        properties.setProperty("capacity", "10");

        Enumeration<?> enumeration = properties.propertyNames();

        while (enumeration.hasMoreElements()) {
            String s = (String) enumeration.nextElement();
            System.out.println(s + " = " + properties.getProperty(s));
        }
        System.out.println();
        properties.setProperty("size", "20");
        System.out.println("size = " + properties.getProperty("capacity", "20"));
        System.out.println("loadfactor = " + properties.getProperty("loadfactor", "0.75"));

        System.out.println(properties);
        properties.list(System.out);
    }
}
