package org.example.graph.dagsp;

import org.example.graph.topo.KahnTopo;
import org.example.graph.utils.Graph;
import java.util.*;

public class DAGShortestPath {
    public int[] findShortestPath(Graph graph, int source) {
        int n = graph.getVertexCount();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        List<Integer> topoOrder = new KahnTopo().topologicalSort(graph);
        System.out.println("Topological Order: " + topoOrder);

        for (int u : topoOrder) {
            if (dist[u] == Integer.MAX_VALUE) {
                continue;
            }

            for (int v : graph.getNeighbors(u)) {
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                }
            }
            System.out.println("Distances after processing node " + u + ": " + Arrays.toString(dist));
        }

        return dist;
    }
}