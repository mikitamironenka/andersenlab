package by.mironenka.collections.graph;

import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Graph(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return this.adjVertices;
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(vertex));
        adjVertices.remove(new Vertex(label));
    }

    /**
     * Creates a new Edge and updates the adjacent vertices Map.
     * @param labelOne
     * @param labelTwo
     */
    public void addEdge(String labelOne, String labelTwo) {
        Vertex vertexOne = new Vertex(labelOne);
        Vertex vertexTwo = new Vertex(labelTwo);
        adjVertices.get(vertexOne).add(vertexTwo);
        adjVertices.get(vertexTwo).add(vertexOne);
    }


    public void removeEdge(String labelOne, String labelTwo) {
        Vertex vertexOne = new Vertex(labelOne);
        Vertex vertexTwo = new Vertex(labelTwo);
        List<Vertex> edgeVertexOne = adjVertices.get(vertexOne);
        List<Vertex> edgeVertexTwo = adjVertices.get(vertexTwo);
        if (edgeVertexOne != null) {
            edgeVertexOne.remove(vertexTwo);
        }
        if (edgeVertexTwo != null) {
            edgeVertexTwo.remove(vertexOne);
        }
    }

    /**
     * Method to get the adjacent vertices of a particular vertex
     * @param label name of a vertex
     * @return list of adjacent vertices
     */
    public List<Vertex> getAdjVertices(String label) {
        return this.adjVertices.get(new Vertex(label));
    }

    public String breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        String mangoSeller = null;
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertexName = queue.poll();
            for (Vertex vertex : graph.getAdjVertices(vertexName)) {
                String label = vertex.getLabel();
                if (label.contains("m")) {
                    mangoSeller = label;
                    break;
                }
                if (!visited.contains(label)) {
                    visited.add(label);
                    queue.add(label);
                }
            }
        }
        return mangoSeller;
    }


}
