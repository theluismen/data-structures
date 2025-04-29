package graph;

import java.util.*;

// Clase que representa una arista dirigida con peso entero
class Edge {
    String target; // Nodo destino
    int weight; // Peso de la arista

    public Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "→ " + target + " [peso: " + weight + "]";
    }
}

class Node implements Comparable<Node> {
    String name;
    int distance;

    public Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // Ordenar por distancia ascendente
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

// Clase del grafo dirigido con pesos
public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    // Agregar un nodo
    public void addNode(String label) {
        adjList.putIfAbsent(label, new ArrayList<>());
    }

    // Agregar una arista dirigida con peso
    public void addEdge(String from, String to, int weight) {
        addNode(from);
        addNode(to);
        adjList.get(from).add(new Edge(to, weight));
    }

    // Obtener vecinos de un nodo
    public List<Edge> getNeighbors(String label) {
        return adjList.getOrDefault(label, new ArrayList<>());
    }

    // Mostrar el grafo
    public void printGraph() {
        for (String node : adjList.keySet()) {
            System.out.print(node + " -> ");
            System.out.println(adjList.get(node));
        }
    }

    // Verificar si el nodo existe
    public boolean containsNode(String label) {
        return adjList.containsKey(label);
    }

    // Verificar si una arista con peso existe
    public boolean hasEdge(String from, String to, int weight) {
        if (!adjList.containsKey(from))
            return false;
        for (Edge e : adjList.get(from)) {
            if (e.target.equals(to) && e.weight == weight)
                return true;
        }
        return false;
    }

    public Map<String,Integer> dijkstra ( String start ) {
        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        // Inicializar map distancias con los nodos existentes
        for ( String n : adjList.keySet() ) 
            distancias.put( n, Integer.MAX_VALUE); // Inicializar con infinito
        
        // Distancia del nodo inicial a el mismo 0
        distancias.put(start, 0); 
        pq.add( new Node(start,0) );

        while ( ! pq.isEmpty() ) {
            Node current = pq.poll();

            if ( visited.contains( current.name ) )
                continue;
            
            visited.add( current.name );

            for ( Edge edge: this.getNeighbors( current.name ) ) { 
                int newDist = distancias.get(current.name) + edge.weight;

                if ( newDist < distancias.get(edge.target)) {
                    distancias.put( edge.target, newDist );
                    pq.add( new Node( edge.target, newDist) );
                }
            }
        }

        return distancias;
    }
}


/*
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "D", 3);

        graph.printGraph();
    }
}

 */