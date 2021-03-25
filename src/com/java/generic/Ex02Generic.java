package com.java.generic;

import java.util.ArrayList;

public class Ex02Generic {
    public static void main(String[] args) {
        Box2<Fruit> fruitBox = new Box2<>();
        Box2<Apple> appleBox2 = new Box2<>();
        Box2<Toy> toyBox2 = new Box2<>();
        //Box2<Grape> grapeBox2 = new Box2<Apple>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        appleBox2.add(new Apple());
        toyBox2.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox2);
        System.out.println(toyBox2);
    }
}

class Fruit{public String toString() {return "Fruit";}}
class Apple extends Fruit{public String toString() {return "Apple";}}
class Grape{public String toString() {return "Grape";}}
class Toy{public String toString() {return "Toy";}}

class Box2<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item){ list.add(item);}
    T get(int i){return list.get(i);}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}
