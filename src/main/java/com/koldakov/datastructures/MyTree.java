package com.koldakov.datastructures;

class MyTree {

    public static void main(String[] args) {
        Node root = addNode(null, 4);
        root = addNode(root, 3);
        root = addNode(root, 5);

        System.out.println(root.left.value);
        System.out.println(root.value);
        System.out.println(root.right.value);
    }

    static Node addNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (value <= node.value) {
                node.left = addNode(node.left, value);
            } else {
                node.right = addNode(node.right, value);
            }
            return node;
        }
    }

    static class Node {
        final int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}
