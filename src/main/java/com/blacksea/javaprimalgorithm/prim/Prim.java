package com.blacksea.javaprimalgorithm.prim;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * graph is keeps list of vertex
 */
public class Prim {
    private List<Vertex> graph = new ArrayList<>();

    public Prim() {
    }

    public Prim(List<Vertex> graph) {
        this.graph = graph;
    }

    /**
     *
     * @param sourceVertex
     * @param targetVertex
     * @param edge
     */
    public void addVertex(Vertex sourceVertex,Vertex targetVertex,Edge edge) {
        int sourceVertexIndex = graph.indexOf(sourceVertex);
        int targetVertexIndex = graph.indexOf(targetVertex);
        sourceVertex.addEdge(targetVertex,edge);
        targetVertex.addEdge(sourceVertex,edge);
        if (sourceVertexIndex > 0) {
            this.graph.set(sourceVertexIndex,sourceVertex);
        } else {
            this.graph.add(sourceVertex);
        }
        if (targetVertexIndex > 0) {
            this.graph.set(targetVertexIndex,targetVertex);
        } else {
            this.graph.add(targetVertex);
        }
    }

    /**
     * this method scans prim graph and calculates mst
     * first checking if graph is empty, we consider graph is not empty in this case
     * In prim algorithm we should visit all vertexes in graph and we are starting from first vertex of graph list and setting its visited value to true
     * while there is not exist any graph without visited loop block must be run
     */
    public void scanPrimAlgorithm() {
        if (!graph.isEmpty()) {
            graph.get(0).setVisited(true);
        }
        while (graph.stream().anyMatch(v -> !v.isVisited())) {
            Edge nextMinimumEdge = new Edge(); // We are created an edge with weight Integer.MAX ( look inside the edge class )
            Vertex nextVertex = graph.get(0); // We are setting nextVertex's value from graph's first item because of disable null pointers
            for (Vertex vertex : graph) {
                if (vertex.isVisited()) { // checks is vertex visited
                    Pair<Vertex, Edge> temp = vertex.nextMinimum();
                    if (temp.getValue().getWeight() < nextMinimumEdge.getWeight()) { // if temp weight minimal than we should set temp as next minimum edge
                        nextMinimumEdge = temp.getValue();
                        nextVertex = temp.getKey();
                    }
                }
            }
            nextMinimumEdge.setIncluded(true);
            nextVertex.setVisited(true);
            // setting visited value. We are done with this vertex.
            // Now function scans next vertex until there is not exist any vertex without visited
        }
    }

    public void printAllGraph(){
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.originalToString());
        }
        System.out.println(sb.toString());
        this.resetPrintHistory();
    }

    private void resetPrintHistory(){
        if (!graph.isEmpty()) {
            for (Vertex vertex : graph){
                for (Map.Entry<Vertex, Edge> vertexEdgeEntry : vertex.getEdgeMap().entrySet()) {
                    vertexEdgeEntry.getValue().setPrinted(false);
                }
            }
        }
    }

    public void printMst(){
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.includedToString());
        }
        System.out.println(sb.toString());
        this.resetPrintHistory();
    }
}
