package com.java.evaluation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NonInterference {

    @Test
    void non_interference(){
        List l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> stream = l.stream();
        l.add("three");
        String collect = stream.collect(Collectors.joining(" "));
        System.out.println("collect = " + collect);
    }

    @Test
    void is_it_infinite_stream(){
        IntStream.iterate( 1, i -> i+1 )
                .map(i -> {
                    System.out.println("iterate = " + i);
                    return i;
                })
                .map( i -> i * 2 )
                .filter( i -> i > 5 )
                .findFirst();
    }
}
