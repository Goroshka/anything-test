package com.koldakov.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @Before
    public void newList() {
        list = new MyLinkedList<>();
    }


    @Test
    public void add() {
        assertEquals(0, list.size);
        list.add(3);
        assertEquals(1, list.size);
        list.add(5);
        assertEquals(2, list.size);
    }


    @Test
    public void addToIndex() {
        list.add(5);

        list.add(3, 0);
        list.add(4, 1);

        assertEquals(3, list.size);
        assertEquals(3, (int) list.get(0));
        assertEquals(4, (int) list.get(1));
        assertEquals(5, (int) list.get(2));
    }

    @Test
    public void addToIndexIntoEmpty() {
        list.add(3, 0);

        assertEquals(1, list.size);
        assertEquals(3, (int) list.get(0));
    }

    @Test
    public void addToIndexToEnd() {
        list.add(3);

        list.add(5, 1);

        assertEquals(2, list.size);
        assertEquals(3, (int) list.get(0));
        assertEquals(5, (int) list.get(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void addToIndexOutOfBounds() {
        list.add(3);

        list.add(5, 2);
    }


    @Test
    public void get() {
        list.add(3);
        list.add(5);

        assertEquals(3, (int) list.get(0));
        assertEquals(5, (int) list.get(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void getFromEmptyOutOfBounds() {
        list.get(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void getOutOfBounds() {
        list.add(3);
        list.add(5);

        list.get(2);
    }


    @Test
    public void remove() {
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(1);

        assertEquals(2, list.size);
        assertEquals(3, (int) list.get(0));
        assertEquals(5, (int) list.get(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFromEmptyOutOfBounds() {
        list.remove(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeOutOfBounds() {
        list.add(3);
        list.add(5);

        list.remove(2);
    }


    @Test
    public void replace() {
        list.add(7);
        list.add(8);
        list.add(9);

        list.replace(3, 0);
        list.replace(4, 1);
        list.replace(5, 2);

        assertEquals(3, list.size);
        assertEquals(3, (int) list.get(0));
        assertEquals(4, (int) list.get(1));
        assertEquals(5, (int) list.get(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void replaceIntoEmptyOutOfBounds() {
        list.replace(3, 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void replaceOutOfBounds() {
        list.add(3);

        list.replace(5, 1);
    }


    @Test
    public void sort() {
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);

        list.sort(Integer::compareTo);

        assertEquals(5, list.size);
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
    }

    @Test
    public void sortEmpty() {
        list.sort(Integer::compareTo);

        assertEquals(0, list.size);
    }


    @Test
    public void toStringEmpty() {
        assertEquals("List is empty", list.toString());
    }

    @Test
    public void toStringTest() {
        list.add(5);
        list.add(3);
        list.add(4);

        assertEquals("List is: [5, 3, 4]", list.toString());
    }
}
