package com.java.study_Function;

import java.util.function.Function;

public class StudyFunction05 {
    public static void main(String[] args) {

        /*
            default<V> Function<T, V> andThen(Function<? super R, ? extends V> after)
            default<V> Function<V, R> compose(Function<? super V, ? extends R> before)
            static <T> Function<T, T> identity()
         */
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
        Function<String, String> h = f.andThen(g);

        System.out.println(h.apply("FF"));

        Function<Integer, String> gg = (i) -> Integer.toBinaryString(i);
        Function<String, Integer> ff = (s) -> Integer.parseInt(s, 16);
        Function<Integer, Integer> hh = f.compose(g);
        System.out.println(hh.apply(2));

        // identity() : 함수를 적용하기 이전과 이후가 동일한 항등 함수가 필요할 때 사용한다.
         Function<String, String> fff = x -> x;
        System.out.println(f.apply("AAA"));
        // 잘 사용되지 않는 편이며, 나중에 배울 map()으로 변환작업할 때, 변환없이 그대로 처리하고자 할 때 사용된다.

    }
}
