package com.javacloud.jgrapht;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Test {

  public static void main(String[] args) {
    DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
    String google = "google";
    String wikipedia = "wk";
    String jgrapht = "jgt";
    // add the vertices
    g.addVertex(google);
    g.addVertex(wikipedia);
    g.addVertex(jgrapht);

    // add edges to create linking structure
    g.addEdge(jgrapht, wikipedia);
    g.addEdge(google, jgrapht);
    g.addEdge(google, wikipedia);
    g.addEdge(wikipedia, google);
    g.getEdgeSupplier();
  }
}
