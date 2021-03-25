package com.java.generic;

public class Ex01Generic {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<String>("A");
        System.out.println(stringBox.item);
    }
}
// 지네릭 클래스로 변경하기
class Box<T> {
    T item;
    Box(T item){
        this.item = item;
    }
}
