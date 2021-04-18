package com.java.study_lambda;

public class StudyLambda03 {
    public static void main(String[] args) {
        
        // 함수형 인터페이스 타입의 매개변수와 반환타입
        MyFunction f1 = () -> System.out.println("r1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute( () -> System.out.println("run()"));
    }

    @FunctionalInterface
    interface MyFunction {
        void run(); // public abstract void run()
    }

    static void execute(MyFunction function) {
        function.run();
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }
}
