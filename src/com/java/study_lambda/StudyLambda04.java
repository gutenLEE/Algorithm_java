package com.java.study_lambda;

public class StudyLambda04 {

    @FunctionalInterface
    interface MyFunction {
        void myMethod();
    }

    public static void main(String[] args) {
        /*
           람다식은 익명 객체이고 익명 객체는 타입이 없다.
           정확히는 타입은 있지만 컴파일러가 임의로 이름을 정하기 때문에 알 수 없는 것이다.

           그래서 대입 연산자 양변의 타입을 일치시키기 위해 아래와 같이 형변환이 필요하다.
           람다식은 MyFuction 인터페이스를 직접 구현하지 않았지만, 이 인터페이스를 구현한 클래스의 객체와
            완전히 동일하기 때문에 아래와 같은 형변환을 허용한다. 그리고 이 형변환은 생략 가능하다. 

            람다식은 오직 함수형 인터페이스로만 형변환이 가능하다.
         */
        MyFunction f = (MyFunction) () -> {};


        // 굳이 Object 타입으로 형변환하려면, 먼저 함수형 인터페이스로 변환해야 한다.
        Object obj = (Object) (MyFunction)() -> {};

    }
}
