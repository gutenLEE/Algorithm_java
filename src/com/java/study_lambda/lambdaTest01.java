package com.java.study_lambda;

public class lambdaTest01 {
    public static void main(String[] args) {
        // 메서드를 하나의 식으로 표현한 것
        // 메서드의 이름과 반환값이 없으므로 람다식을 익명함수라고도 한다.

        // 메서드를 변수처럼 다루는 것이 가능하다. 또한 매개변수로 전달도 가능하다.

    }
    public void process(Runnable r){r.run();}

    public void test() {
        process(() -> {
            System.out.println("hello world");
        });
    }

}
