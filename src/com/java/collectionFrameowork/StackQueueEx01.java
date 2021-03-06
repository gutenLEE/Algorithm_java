package com.java.collectionFrameowork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx01 {
    public static void main(String[] args) {
        Stack st = new Stack<>();
        Queue queue = new LinkedList();

        st.push("a");
        st.push("b");
        st.push("c");

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        System.out.println("스택");
        while (!st.isEmpty())
            System.out.println(st.pop());

        System.out.println("큐");
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
