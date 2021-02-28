package com.java.Exception;

public class Exception01 {
    public static void main(String[] args) {
        try{
            Exception e = new Exception("고의로 발생");
            throw e;
        }
        catch (Exception e){
            System.out.println("error msg " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("정상 종료");
    }
}
