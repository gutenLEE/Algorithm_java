package com.java.OOP;

public class BindingTest {
    public static void main(String[] args) {
        BindingTestParent p = new BindingTestChild();
        BindingTestChild c = new BindingTestChild();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }

}
class BindingTestParent{
    // 조상 클래스에 선언된 멤버변수
    int x = 100;

    void method(){
        System.out.println("parent method");
    }
}
class BindingTestChild extends BindingTestParent{

    // 조상클래스에 선언된 멤버 변수와 같은 이름의 인스턴스 변수를 자손 클래스에 중복으로 정의했을 때
    int x = 200;

    void method(){
        System.out.println("child method");
    }
}