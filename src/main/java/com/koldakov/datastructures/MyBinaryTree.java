package com.koldakov.datastructures;

import java.util.Comparator;

/*
 * height is defined as maximum number of edges from node to leaf
 */
public class MyBinaryTree<T> {

    private TreeElement<T> rootElement;

    int height() {
        return height(rootElement);
    }

    private static int height(TreeElement rootElement) {
        int result = 0;
        if (rootElement != null) {
            result = Math.max(height(rootElement.left), height(rootElement.right));
            if (rootElement.left != null || rootElement.right != null) {
                result++;
            }
        }
        return result;
    }

    void insert(T value, Comparator<T> comparator) {
        rootElement = insert(rootElement, value, comparator);
    }

    private static <T> TreeElement<T> insert(TreeElement<T> treeElement, T value, Comparator<T> comparator) {
        if (treeElement == null) {
            treeElement = new TreeElement<>(value);
        } else {
            if (comparator.compare(value, treeElement.value) < 0) {
                treeElement.left = insert(treeElement.left, value, comparator);
            } else if (comparator.compare(value, treeElement.value) > 0) {
                treeElement.right = insert(treeElement.right, value, comparator);
            }
        }
        return treeElement;
    }

    private static class TreeElement<T> {
        final T value;
        TreeElement<T> left;
        TreeElement<T> right;

        TreeElement(T value) {
            this.value = value;
        }
    }
}
