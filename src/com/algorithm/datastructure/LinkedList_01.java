package com.algorithm.datastructure;

import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 백준 5397번, 키로커
 * @author yhlee
 * @created_at 2021-08-24 오후 10:16
 */
public class LinkedList_01 {

    public static void main(String[] args) throws IOException {
        // 입력
        // <, > : insert
        // - : delete

        DoublyLinkedList a = new DoublyLinkedList("A");
        DoublyLinkedList b = new DoublyLinkedList("B");
        System.out.println(a.toString());
        System.out.println(b.toString());

    }
}

@Setter
class Node{

    private Object data;
    private Node next;
    private Node prev;

    public Node(Object input){
        this.data = input;
        this.next = null;
        this.prev = null;
    }

    public Node(Object input, Node prev) {
        this.data = input;
        this.prev = prev;
    }

    public Node(Object input, Node prev, Node next) {
        this.data = input;
        this.prev = prev;
        this.next =  next;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}

@Setter @ToString
class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList(Object data) {
        this.head = new Node(data);
        this.tail = this.head;
    }
}