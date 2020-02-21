package com.koldakov.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class MyStackTest {

    private MyStack<String> stack;

    @Before
    public void newStack() {
        stack = new MyStack<>();
    }

    @Test
    public void push() {
        stack.push("B");
        stack.push("A");

        assertEquals(2, stack.size);
    }


    @Test(expected = NoSuchElementException.class)
    public void popEmptyStack() {
        stack.pop();
    }

    @Test
    public void pop() {
        stack.push("B");
        stack.push("A");

        assertEquals("A", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals(0, stack.size);
    }


    @Test
    public void peek() {
        stack.push("B");
        stack.push("A");

        assertEquals("A", stack.peek());
        assertEquals("A", stack.peek());
        assertEquals(2, stack.size);
    }


    @Test
    public void toStringEmpty() {
        assertEquals("Stack is empty", stack.toString());
    }

    @Test
    public void toStringTest() {
        stack.push("C");
        stack.push("B");
        stack.push("A");

        assertEquals("Stack is: [A, B, C]", stack.toString());
    }
}
