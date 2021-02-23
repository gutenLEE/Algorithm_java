package com.java;

class Data{int x;}

public class ReferenceReturnEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;

        Data d2 = copy(d);

        System.out.println("d.x = " + d.x);
        System.out.println("d2.x = " + d2.x);
    }
    static Data copy(Data d){
        Data tmp = new Data();
        tmp.x = d.x;
        // copy 메서드 내에서 생성한 객체를 main 메서드에서 사용할 수 있으려면, 새로운 객체의 주소를 반환해주어야 한다.
        // 그렇지 않으면, copy 메서드가 종료되면서 새로운 객체의 참조가 사라지기 때문에 더 이상 이 객체를 사용할 방법이 없다.
        return tmp;
    }
}
