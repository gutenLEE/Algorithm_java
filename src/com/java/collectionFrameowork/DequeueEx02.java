package com.java.collectionFrameowork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class DequeueEx02 {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);

        System.out.println("deque = " + deque);
        System.out.println();
        deque.clear();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        System.out.println("deque = " + deque);

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
        System.out.println("====");

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        Iterator iterator1 = stack.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
