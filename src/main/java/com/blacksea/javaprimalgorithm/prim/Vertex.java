package com.blacksea.javaprimalgorithm.prim;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * edge map stores connections among vertex
 * isVisited shows is vertex visited
 */
public class Vertex {
    private String name;
    private Map<Vertex,Edge> edgeMap = new HashMap<Vertex, Edge>();
    private boolean isVisited;

    public Vertex() {
        this.isVisited = false;
    }

    public Vertex(String name) {
        this.name = name;
        this.isVisited = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Vertex, Edge> getEdgeMap() {
        return edgeMap;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    /**
     * Adding vertex to edge. First checks is vertex contains in edge map
     * if vertex contains in edge map than checks given edge's weight and existing edge's weight.
     * we should keep edge which has the minimal weight
     * @param vertex
     * @param edge
     */
    void addEdge(Vertex vertex, Edge edge) {
        if (this.edgeMap.containsKey(vertex)) {
            if (edge.getWeight() < this.edgeMap.get(vertex).getWeight()) {
                this.edgeMap.replace(vertex,edge);
            }
        } else {
            this.edgeMap.put(vertex,edge);
        }
    }

    Pair<Vertex, Edge> nextMinimum(){
        Edge nextMinimum = new Edge(Integer.MAX_VALUE);
        Vertex nextVertex = this;
        for (Map.Entry<Vertex, Edge> pair : edgeMap.entrySet()) {
            if (!pair.getKey().isVisited()) {
                if (!pair.getValue().isIncluded()) {
                    if (pair.getValue().getWeight() < nextMinimum.getWeight()) {
                        nextMinimum = pair.getValue();
                        nextVertex = pair.getKey();
                    }
                }
            }
        }
        return new Pair<Vertex,Edge>(nextVertex, nextMinimum);
    }

    String originalToString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex, Edge> vertexEdgeEntry : this.edgeMap.entrySet()) {
            if (!vertexEdgeEntry.getValue().isPrinted()) {
                sb.append(this.getName())
                        .append(" --- ")
                        .append(vertexEdgeEntry.getKey().getName())
                        .append(" --- ")
                        .append(vertexEdgeEntry.getValue().getWeight() + "\n");
                vertexEdgeEntry.getValue().setPrinted(true);
            }
        }
        return sb.toString();
    }

    String includedToString(){
        StringBuilder sb = new StringBuilder();
        if (isVisited()) {
            for (Map.Entry<Vertex, Edge> vertexEdgeEntry : this.edgeMap.entrySet()) {
                if (vertexEdgeEntry.getValue().isIncluded() && !vertexEdgeEntry.getValue().isPrinted()) {
                    sb.append(getName());
                    sb.append(" --- ");
                    sb.append(vertexEdgeEntry.getKey().getName());
                    sb.append(" --- ");
                    sb.append(vertexEdgeEntry.getValue().getWeight());
                    sb.append("\n");
                    vertexEdgeEntry.getValue().setPrinted(true);
                }
            }
        }
        return sb.toString();
    }
}
