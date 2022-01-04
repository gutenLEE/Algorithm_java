package com.java.evaluation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class LazyAndEagerEvaluation {

    @Test
    void work_element_each_stage(){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(5);
        a.add(8);
        a.add(7);
        a.add(3);
        a.add(65);
        a.add(87);
        a.add(2);
        a.add(12);
        a.add(58);
        a.add(42);

        Stream<Integer> st =
                a.stream()
                 .filter( b -> {
                            System.out.println("Tested: " + b);
            return (b%2)==0;
        });

        Spliterator<Integer> it = st.spliterator();

        System.out.println("\n\nIterator Results:");
        while(it.tryAdvance( (j) ->
                System.out.println("iter: "+j))
        );

        System.out.println("Last Statement");
    }
}
