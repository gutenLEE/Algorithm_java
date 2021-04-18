package com.java.study_lambda;

import java.util.*;

public class StudyLambda02 {
    public static void main(String[] args) {
        // 람다식은 참조 변수에 할당이 가능하다. 그렇다면 참조변수의 타입은 ?
        // 클래스 또는 인터페이스
        // 하나의 메서드가 선언된 인터페이스를 정의해서 람다식을 다루는 것은 기존의 자바의 규칙들을 어기지 않으면서도 자연스럽다.
        // 그래서 인터페이스를 통해 람다식을 다루기로 결정되었으며, 람다식을 다루기 위한 인터페이스를 함수형 인터페이스라고 한다.

        // 단, 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어 있어야 한다는 제약이 있다. 1 : 1연결때문에

        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        // 람다식으로 

        MyFunction f2 = (int a, int b) -> a > b ? a : b;

        // ================================================================

        List<String> list = Arrays.asList("abc", "def", "hij");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // 람다식 변형
        List<String> list2 = Arrays.asList("abc", "def", "hij");
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));

    }

    interface MyFunction{
        public abstract int max(int a, int b);
    }
}


