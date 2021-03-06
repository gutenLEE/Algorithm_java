package com.java.collectionFrameowork;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx01 {
    public static void main(String[] args) {
        Queue pq = new PriorityQueue();
        pq.offer(4);
        pq.offer(5);
        pq.offer(1);
        pq.offer(6);
        pq.offer(7);
        pq.offer(10);
        pq.offer(3);

        System.out.println(pq);

        Object obj = null;

        while((obj = pq.poll()) != null)
            System.out.println(obj);
    }
}
