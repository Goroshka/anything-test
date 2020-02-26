package com.koldakov.datastructures;

import java.util.Comparator;

/*
 * height is defined as maximum number of edges from node to leaf
 */
public class MyBinaryTree<T> {

    private TreeElement<T> rootElement;

    public int height() {
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

    public void insert(T value, Comparator<T> comparator) {
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

    public String levelOrder() {
        if (rootElement == null) {
            return "Tree is empty";
        }

        StringBuilder result = new StringBuilder();
        result.append("Tree is: [");

        int height = height();
        // since height is defined as maximum number of edges from node to leaf
        // we have to iterate one moe time to get last level leafs
        for (int i = 1; i <= height + 1; i++) {
            result.append(levelOrder(rootElement, i));
        }

        return result.delete(result.length() - 1, result.length()).append("]").toString();
    }

    private static <T> String levelOrder(TreeElement<T> treeElement, int level) {
        if (treeElement == null) {
            return "";
        }

        if (level == 1) {
            return treeElement.value + " ";
        } else {
            return levelOrder(treeElement.left, level - 1) +
                    levelOrder(treeElement.right, level - 1);
        }
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
