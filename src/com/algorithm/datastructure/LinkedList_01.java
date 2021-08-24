package com.algorithm.datastructure;

/**
 * 백준 5397번, 키로커
 * @author yhlee
 * @created_at 2021-08-24 오후 10:16
 */
public class LinkedList_01 {
    public static void main(String[] args) {
        // 입력
        // <, > : insert
        // - : delete
        

    }
}

class Node{
    private Object data;
    private Node next;
    private Node prev;

    public Node(Object input){
        this.data = input;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}

class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int size = 0;
}