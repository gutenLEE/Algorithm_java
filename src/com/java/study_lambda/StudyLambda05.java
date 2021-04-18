package com.java.study_lambda;

class Outer {
    // 외부 변수를 참조하는 람다식
    @FunctionalInterface
    interface MyFunction{
        void myMethod();
    }

    int val = 10; // Outer.this.val

    class Inner{
        int val = 20; // this.val

        void method(int i) {

            int val = 30;

            // i = 10 -> 에러. 상수의 값을 변경할 수 없다.
            MyFunction f = () -> { // i -> 에러. 외부 지역변수와 이름이 중복된다.
                System.out.println("i = " + i);
                System.out.println("val = " + val);
                System.out.println("this.val = " + this.val);
                System.out.println("StudyLambda05.this.val = " + Outer.this.val);
            };
            f.myMethod();
        }
    }// end Inner
} // end Outer

public class StudyLambda05{
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}