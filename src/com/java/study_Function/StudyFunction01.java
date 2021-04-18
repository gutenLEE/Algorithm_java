package com.java.study_Function;

import java.util.function.Predicate;

public class StudyFunction01 {
    public static void main(String[] args) {

        // java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를
        // 함수형 인터페이스로 미리 정의해 놓았다.
        // 매번 새로운 함수형 인터페이스를 정의하지 말고, 가능하면 이 패키지의 인터페이스를 활용하는 것이 좋다.

        /*
            주요 함수형 인터페이스
            java.lang.Runnable
            Supplier<T>
            Consumer<T>
            Function<T,R>
            Predicate<T>
            sdf
         */

        // 조건식에 표현이 사용되는  Predicate
        // Predicate는  Fuction의 변형으로 반환타입이 boolean이다. 조건식을 람다식으로 표현하는데 사용된다.

        Predicate<String> isEmptyStr = s -> s.length() == 0;
        String s = "";

        if (isEmptyStr.test(s)) {
            System.out.println("This is a empty String");
        }
    }
}
