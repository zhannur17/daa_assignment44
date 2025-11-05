package org.example.graph.dagsp;

import org.example.graph.utils.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DAGTest {

    @Test
    public void testDAGShortestPath() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        DAGShortestPath dagSP = new DAGShortestPath();
        int[] shortestPaths = dagSP.findShortestPath(graph, 0);

        int[] expectedShortestPaths = {0, 1, 2, 3, 4, 5};

        System.out.println("Shortest Paths: " + Arrays.toString(shortestPaths));
        assertArrayEquals(expectedShortestPaths, shortestPaths, "Shortest paths do not match");
    }

    @Test
    public void testDAGLongestPath() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        DAGLongestPath dagLP = new DAGLongestPath();
        int[] longestPaths = dagLP.findLongestPath(graph, 0);

        int[] expectedLongestPaths = {0, 1, 2, 3, 4, 5};

        System.out.println("Longest Paths: " + Arrays.toString(longestPaths));
        assertArrayEquals(expectedLongestPaths, longestPaths, "Longest paths do not match");
    }
}
