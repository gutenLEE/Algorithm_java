package com.java.collectionFrameowork;

import java.util.ArrayList;
import java.util.Properties;

public class PropertiesEx04 {
    public static void main(String[] args) {
        Properties sysProp = System.getProperties();
        System.out.println("java.version : " + sysProp.getProperty("java.version"));
        System.out.println("user.language :" + sysProp.getProperty("user.language"));
        sysProp.list(System.out);
        ArrayList<String> arr = new ArrayList<String>();
    }
}
