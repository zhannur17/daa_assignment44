package org.example.graph.utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int n;
    private List<List<Integer>> adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }

    public int getVertexCount() {
        return n;
    }
}
