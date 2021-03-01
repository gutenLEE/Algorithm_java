package com.java.Lang;

import java.util.Objects;

public class ObjectsEx01 {
    public static void main(String[] args) {
        String[][] str2D = new String[][]{{"A", "C"}, {"D", "E"}};
        String[][] str2D2 = new String[][]{{"A", "C"}, {"D", "E"}};

        System.out.println(Objects.deepEquals(str2D, str2D2));
    }
}
