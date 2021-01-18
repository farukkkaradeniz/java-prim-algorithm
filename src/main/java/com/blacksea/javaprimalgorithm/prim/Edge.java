package com.blacksea.javaprimalgorithm.prim;

/**
 * Each edge must have a weight.
 * isIncluded shows the edge presents in mst
 */
public class Edge {
    private int weight;
    private boolean isIncluded;
    private boolean isPrinted;

    public Edge() {
        this.weight = Integer.MAX_VALUE;
        this.isIncluded = false;
        this.isPrinted = false;
    }

    public Edge(int weight) {
        this.weight = weight;
        this.isIncluded = false;
        this.isPrinted = false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean included) {
        isIncluded = included;
    }

    public boolean isPrinted() {
        return isPrinted;
    }

    public void setPrinted(boolean printed) {
        isPrinted = printed;
    }
}
