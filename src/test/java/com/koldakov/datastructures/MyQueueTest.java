package com.koldakov.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue<Integer> queue;

    @Before
    public void createQueue() {
        queue = new MyQueue<>();
    }

    @Test
    public void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size);
    }

    @Test
    public void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(0, queue.size);
    }
}
