package com.koldakov.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class MyGraphTest {

    private MyGraph graph;

    @Before
    public void createGraph() {
        graph = new MyGraph();
    }

    @Test
    public void addVertices() {
        graph.addVertex("V1");
        graph.addVertex("V2");

        assertThat(graph.getAdjacentVertices().keySet().stream().map(v -> v.label).collect(Collectors.toSet()))
                .containsExactlyInAnyOrder("V1", "V2");
    }

    @Test
    public void breadthFirstTraversal() {
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        assertEquals("[Bob, Alice, Rob, Mark, Maria]", graph.breadthFirstTraversal("Bob").toString());
    }

    @Test
    public void depthFirstTraversal() {
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        assertEquals("[Bob, Rob, Maria, Alice, Mark]", graph.depthFirstTraversal("Bob").toString());
    }
}
