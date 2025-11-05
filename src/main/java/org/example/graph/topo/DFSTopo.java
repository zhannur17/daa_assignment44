package org.example.graph.topo;

import org.example.graph.utils.Graph;
import java.util.*;

public class DFSTopo {
    private boolean[] visited;
    private Stack<Integer> topoStack;

    public DFSTopo(Graph graph) {
        visited = new boolean[graph.getVertexCount()];
        topoStack = new Stack<>();
    }

    public List<Integer> topologicalSort(Graph graph) {
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!topoStack.isEmpty()) {
            topologicalOrder.add(topoStack.pop());
        }
        return topologicalOrder;
    }

    private void dfs(Graph graph, int u) {
        visited[u] = true;
        for (int v : graph.getNeighbors(u)) {
            if (!visited[v]) {
                dfs(graph, v);
            }
        }
        topoStack.push(u);
    }
}
