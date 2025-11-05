package org.example.graph.scc;

import org.example.graph.utils.Graph;
import java.util.*;

public class TarjanSCC {
    private int time = 0;
    private List<List<Integer>> sccList;
    private Stack<Integer> stack;
    private boolean[] onStack;
    private int[] ids;
    private int[] lowLink;

    public TarjanSCC(Graph graph) {
        sccList = new ArrayList<>();
        stack = new Stack<>();
        onStack = new boolean[graph.getVertexCount()];
        ids = new int[graph.getVertexCount()];
        lowLink = new int[graph.getVertexCount()];
        Arrays.fill(ids, -1);
        Arrays.fill(lowLink, -1);

        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (ids[i] == -1) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(Graph graph, int u) {
        stack.push(u);
        onStack[u] = true;
        ids[u] = lowLink[u] = time++;

        for (int v : graph.getNeighbors(u)) {
            if (ids[v] == -1) {
                dfs(graph, v);
                lowLink[u] = Math.min(lowLink[u], lowLink[v]);
            } else if (onStack[v]) {
                lowLink[u] = Math.min(lowLink[u], ids[v]);
            }
        }

        if (ids[u] == lowLink[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int v = stack.pop();
                onStack[v] = false;
                scc.add(v);
                if (v == u) break;
            }
            sccList.add(scc);
        }
    }

    public List<List<Integer>> getSCCs() {
        return sccList;
    }
}
