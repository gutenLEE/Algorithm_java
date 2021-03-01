package com.java.Lang;

public class CloneEx01 {
    public static void main(String[] args) {
        Point1 p1 = new Point1(1, 2);
        Point1 p2 = p1.clone();

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
}

class Point1 implements Cloneable{
    int x, y;

    Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "x=" + x + " y=" + y;
    }
    // 오버라이딩
    public Point1 clone(){
        Object obj = null;
        try{
            obj = super.clone();
        }
        catch (CloneNotSupportedException e){ }
        //공변반환타입입
       return (Point1) obj;
    }
}