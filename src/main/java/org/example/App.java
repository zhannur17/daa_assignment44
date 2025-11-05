package org.example;

import org.example.graph.utils.Graph;
import org.example.graph.scc.TarjanSCC;
import org.example.graph.scc.KosarajuSCC;
import org.example.graph.dagsp.DAGShortestPath;
import org.example.graph.dagsp.DAGLongestPath;
import org.example.graph.topo.KahnTopo;
import org.example.graph.topo.DFSTopo;
import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        try {
            Graph graph = parseGraph("src/main/resources/data/tasks.json");

            TarjanSCC tarjanSCC = new TarjanSCC(graph);
            List<List<Integer>> tarjanSCCs = tarjanSCC.getSCCs();
            System.out.println("Tarjan's SCCs: " + tarjanSCCs);

            KosarajuSCC kosarajuSCC = new KosarajuSCC(graph);
            List<List<Integer>> kosarajuSCCs = kosarajuSCC.getSCCs();
            System.out.println("Kosaraju's SCCs: " + kosarajuSCCs);

            KahnTopo kahnTopo = new KahnTopo();
            List<Integer> kahnTopoOrder = kahnTopo.topologicalSort(graph);
            System.out.println("Topological Order (Kahn's): " + kahnTopoOrder);

            DFSTopo dfsTopo = new DFSTopo(graph);
            List<Integer> dfsTopoOrder = dfsTopo.topologicalSort(graph);
            System.out.println("Topological Order (DFS): " + dfsTopoOrder);

            DAGShortestPath dagShortestPath = new DAGShortestPath();
            int[] shortestPaths = dagShortestPath.findShortestPath(graph, 0);
            System.out.println("Shortest Paths from node 0: " + Arrays.toString(shortestPaths));


            DAGLongestPath dagLongestPath = new DAGLongestPath();
            int[] longestPaths = dagLongestPath.findLongestPath(graph, 0);
            System.out.println("Longest Paths from node 0: " + Arrays.toString(longestPaths));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Graph parseGraph(String filePath) throws IOException {
        JsonObject jsonObject = JsonParser.parseReader(new FileReader(filePath)).getAsJsonObject();
        int n = jsonObject.get("n").getAsInt();
        Graph graph = new Graph(n);

        JsonArray edges = jsonObject.getAsJsonArray("edges");
        for (JsonElement edgeElement : edges) {
            JsonObject edge = edgeElement.getAsJsonObject();
            int u = edge.get("u").getAsInt();
            int v = edge.get("v").getAsInt();
            graph.addEdge(u, v);
        }

        return graph;
    }
}
