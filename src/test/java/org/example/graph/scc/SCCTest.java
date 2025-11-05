package org.example.graph.scc;

import org.example.graph.utils.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SCCTest {

    @Test
    public void testTarjanSCC() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        TarjanSCC tarjanSCC = new TarjanSCC(graph);
        List<List<Integer>> sccs = tarjanSCC.getSCCs();

        System.out.println("Tarjan SCCs: " + sccs);

        assertEquals(6, sccs.size(), "Number of SCCs should be 6");
    }

    @Test
    public void testKosarajuSCC() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);


        KosarajuSCC kosarajuSCC = new KosarajuSCC(graph);
        List<List<Integer>> sccs = kosarajuSCC.getSCCs();

        System.out.println("Kosaraju SCCs: " + sccs);

        assertEquals(6, sccs.size(), "Number of SCCs should be 6");
    }
}
