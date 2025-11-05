package org.example.graph.scc;

import org.example.graph.utils.Graph;
import java.util.*;

public class KosarajuSCC {
    private List<List<Integer>> sccList;
    private boolean[] visited;

    public KosarajuSCC(Graph graph) {
        sccList = new ArrayList<>();
        visited = new boolean[graph.getVertexCount()];

        Stack<Integer> order = new Stack<>();
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (!visited[i]) {
                dfs(graph, i, order);
            }
        }

        Graph reversedGraph = reverseGraph(graph);

        Arrays.fill(visited, false);
        while (!order.isEmpty()) {
            int u = order.pop();
            if (!visited[u]) {
                List<Integer> scc = new ArrayList<>();
                dfsReversed(reversedGraph, u, scc);
                sccList.add(scc);
            }
        }
    }

    private void dfs(Graph graph, int u, Stack<Integer> order) {
        visited[u] = true;
        for (int v : graph.getNeighbors(u)) {
            if (!visited[v]) {
                dfs(graph, v, order);
            }
        }
        order.push(u);
    }

    private void dfsReversed(Graph graph, int u, List<Integer> scc) {
        visited[u] = true;
        scc.add(u);
        for (int v : graph.getNeighbors(u)) {
            if (!visited[v]) {
                dfsReversed(graph, v, scc);
            }
        }
    }

    private Graph reverseGraph(Graph graph) {
        Graph reversed = new Graph(graph.getVertexCount());
        for (int u = 0; u < graph.getVertexCount(); u++) {
            for (int v : graph.getNeighbors(u)) {
                reversed.addEdge(v, u);
            }
        }
        return reversed;
    }

    public List<List<Integer>> getSCCs() {
        return sccList;
    }
}
