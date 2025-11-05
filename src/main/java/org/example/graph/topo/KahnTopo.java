package org.example.graph.topo;

import org.example.graph.utils.Graph;
import java.util.*;

public class KahnTopo {
    public List<Integer> topologicalSort(Graph graph) {
        int n = graph.getVertexCount();
        int[] inDegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : graph.getNeighbors(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : graph.getNeighbors(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return topoOrder;
    }
}
