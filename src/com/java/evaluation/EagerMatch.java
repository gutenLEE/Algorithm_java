package com.java.evaluation;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class EagerMatch {
    static String eagerMatch(boolean b1, boolean b2){
        return b1 && b2 ? "match" : "imcompatible";
    }

    static boolean compute(String st){
        System.out.println("executing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return st.contains("a");
    }

    @Test
    void eager_evaluation(){
        boolean b1 = compute("1");
        boolean b2 = compute("2");
        eagerMatch(b1, b2);
    }

    @Test
    void lazy_evaluation_without_reuse_value() {
        String value = compute("h") && compute("b") ? "o" : "x";
        System.out.println("value = " + value);
    }

    @Test
    void lazy_evaluation_with_reuse_value() {
        Supplier<Boolean> a = () -> compute("h");
        Supplier<Boolean> b = () -> compute("h");
        lazyMatch(a, b);
    }

    static String lazyMatch(Supplier<Boolean> a, Supplier<Boolean> b ){
        return a.get() && b.get() ? "o" : "x";
    }
}


