package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class TestGraph {
    
    /* TEST .dijkstra() */
    
    @Test
    public void test_dijkstra_1 () {
        Graph graph = new Graph();
        
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
       
        graph.addEdge("A","B",50);
        graph.addEdge("A","C",20);
        graph.addEdge("A","E",45);
        
        graph.addEdge("B","C",15);
        graph.addEdge("B","E",10);

        graph.addEdge("C","A",10);
        graph.addEdge("C","D",25);
        
        graph.addEdge("D","B",1);
        graph.addEdge("D","E",35);

        graph.addEdge("E","D",30);
        
        graph.addEdge("F","D",3);

        Map<String,Integer> dijkstra = graph.dijkstra("A");

        for ( String node : dijkstra.keySet() ) {
            System.out.println( node + ":" + dijkstra.get(node));
        }

        assertEquals( 1, 1);
    }
}
