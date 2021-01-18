package com.blacksea.javaprimalgorithm;

import com.blacksea.javaprimalgorithm.prim.Edge;
import com.blacksea.javaprimalgorithm.prim.Prim;
import com.blacksea.javaprimalgorithm.prim.Vertex;

public class Application {
    public static void main(String[] args) {
        Prim prim = new Prim();
        Vertex a_vertex = new Vertex("A");
        Vertex b_vertex = new Vertex("B");
        Vertex c_vertex = new Vertex("C");
        Vertex d_vertex = new Vertex("D");
        Vertex e_vertex = new Vertex("E");
        prim.addVertex(a_vertex,b_vertex,new Edge(2));
        prim.addVertex(a_vertex,c_vertex,new Edge(3));
        prim.addVertex(b_vertex,c_vertex,new Edge(2));
        prim.addVertex(e_vertex,b_vertex,new Edge(5));
        prim.addVertex(c_vertex,d_vertex,new Edge(1));
        prim.addVertex(c_vertex,e_vertex,new Edge(1));

        prim.printAllGraph();
        prim.scanPrimAlgorithm();
        System.out.println( "-------------\n");
        prim.printMst();
    }
}
