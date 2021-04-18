package com.java.study_Function;

import java.util.Arrays;
import java.util.function.*;

public class StudyFunction04 {
    public static void main(String[] args) {
        /*
            효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스들이 제공된다.

            DoubleToIntFunction
            double -> int applyAsInt(double d) -> int
            A To B Function은 입력이 A,  출력이 B

            ToTintFunction<T>
            T -> int applyAsInt(T value) -> int
            To B Function 출력이 B타입이다. 입력은 지네릭

            IntFuction<R>
            int -> R apply(T t, U u) -> R
            A Function 입력이 A 타입, c출력은 지네릭 타입

            ObjIntConsumer<t>
            T, int -> void accept(T t, U u)
            obj A Function은 입력이 T,A 타입. 출력은 없다.
         */

        IntSupplier s = () -> (int)(Math.random() * 100) + 1; // no param, return 1
        IntConsumer c = i -> System.out.print(i + ", "); // param 1, no return
        IntPredicate p = i -> i % 2 == 0; // if condition, return boolean
        IntUnaryOperator op = i -> i / 10 * 10; // 1 param, 1 return

        int[] arr = new int[10];

        makeRandomList(s, arr);
        System.out.println(Arrays.toString(arr));
        printEvenNum(p, c, arr);
        int[] newArr = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static void makeRandomList(IntSupplier s, int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.getAsInt();
        }
    }

    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.print("[");

        for (int i :
                arr) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.print("]");
    }

    static int[] doSomething(IntUnaryOperator op, int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]);
        }
        return newArr;
    }
}
