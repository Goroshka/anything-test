package com.koldakov.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyBinaryTreeTest {

    private MyBinaryTree<Integer> binaryTree = new MyBinaryTree<>();

    @Test
    public void height() {
        binaryTree.insert(4, Integer::compareTo);
        binaryTree.insert(2, Integer::compareTo);
        binaryTree.insert(1, Integer::compareTo);
        binaryTree.insert(3, Integer::compareTo);
        binaryTree.insert(6, Integer::compareTo);
        binaryTree.insert(5, Integer::compareTo);

        assertEquals(2, binaryTree.height());
    }
}
