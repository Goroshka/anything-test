package com.koldakov.datastructures;

import java.util.*;

public class MyGraph {

    private final Map<Vertex, List<Vertex>> adjacentVertices = new HashMap<>();

    public Map<Vertex, List<Vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addVertex(String label) {
        adjacentVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);

        List<Vertex> adjacent1 = adjacentVertices.get(vertex1);
        List<Vertex> adjacent2 = adjacentVertices.get(vertex2);

        if (adjacent1 == null || adjacent2 == null) {
            throw new RuntimeException("Both vertices must be set before adding an edge");
        }
        adjacent1.add(vertex2);
        adjacent2.add(vertex1);
    }

    /**
     * Explores all neighboring vertices at the same level before going deeper in the graph:
     * - Explore start vertex
     * - Explore all connected vertices
     * - Get to any connected vertex, explore all its connected vertices...
     *
     * Queue is used for traversal
     *
     * @param startLabel - start vertex label
     * @return vertices labels in traversed order
     */
    public Set<String> breadthFirstTraversal(String startLabel) {
        Set<String> visited = new LinkedHashSet<>();
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue(startLabel);
        while (queue.size > 0) {
            String labelFromQueue = queue.dequeue();
            if (!visited.contains(labelFromQueue)) {
                visited.add(labelFromQueue);

                for (Vertex vertex : adjacentVertices.get(new Vertex(labelFromQueue))) {
                    queue.enqueue(vertex.label);
                }
            }
        }
        return visited;
    }

    /**
     * Explores vertices as deeper as possible along each branch before exploring vertices at the same level:
     * - Get to start vertex
     * - Explore any one connected vertex
     * - Explore any one of its connected vertex...
     *
     * Stack is used for traversal
     *
     * @param startLabel - start vertex label
     * @return vertices labels in traversed order
     */
    public Set<String> depthFirstTraversal(String startLabel) {
        Set<String> visited = new LinkedHashSet<>();
        MyStack<String> stack = new MyStack<>();

        stack.push(startLabel);
        while (stack.size > 0) {
            String labelFromStack = stack.pop();
            if (!visited.contains(labelFromStack)) {
                visited.add(labelFromStack);

                for (Vertex vertex : adjacentVertices.get(new Vertex(labelFromStack))) {
                    stack.push(vertex.label);
                }
            }
        }
        return visited;
    }
}
