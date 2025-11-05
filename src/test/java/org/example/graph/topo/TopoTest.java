package org.example.graph.topo;

import org.example.graph.utils.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TopoTest {

    @Test
    public void testDFSTopo() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        DFSTopo dfsTopo = new DFSTopo(graph);
        List<Integer> topoOrder = dfsTopo.topologicalSort(graph);

        List<Integer> expectedOrder = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expectedOrder, topoOrder);
    }

    @Test
    public void testKahnTopo() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        KahnTopo kahnTopo = new KahnTopo();
        List<Integer> topoOrder = kahnTopo.topologicalSort(graph);

        List<Integer> expectedOrder = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(expectedOrder, topoOrder);
    }
}
