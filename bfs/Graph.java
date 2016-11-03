/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Zack Wiseman
 * Data Structures
 * Breadth First Search 
 * 11/02/2016
 * 
 * This Class will design a graph of 2d boolean array this class also contains 
 * methods for printing the graph, vertices, getting the size of the graph and 
 * for Breadth First Search algorithm.
 *
 * @author zacharywiseman
 */
public class Graph {

    private final int n;
    private final boolean[][] edges;
    private final Vertex[] vertices;

    /**
     * Constructor that will initialize the size of 2d array edge and 1d array
     * vertices size n and make a deep copy of 2d array edges.the arrays will
     * correspond to the given array and is assumed to be square therefore the
     * size will be determined by the largest square value of the array given.
     *
     * @param edges
     */
    public Graph(boolean[][] edges) {
        this.n = edges.length;
        this.edges = new boolean[n][n];
        vertices = new Vertex[n];
        for (int i = 0; i < edges.length; i++) {
            System.arraycopy(edges[i], 0, this.edges[i], 0, edges.length);
        }
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
    }

    /**
     * Method to get the size, or n of the boolean 2d array given to the
     * constructor.
     *
     * @return
     */
    public int getN() {
        return n;
    }

    /**
     * Method to get the vertex of an integer.
     *
     * @param i
     * @return vertex of integer i
     */
    public Vertex getVertex(int i) {
        return vertices[i];
    }

    /**
     * Method to print the graph edges.
     */
    public void printGraph() {
        // display the graph
        for (int row = 0; row < edges.length; row++) {
            for (int col = 0; col < edges.length; col++) {
                System.out.print(edges[col][row]);
                if (col < edges.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }//printGraph

    /**
     * Method to print the array vertices.
     */
    public void printVertex() {
        for (int i = 0; i < n; i++) {
            System.out.println(vertices[i] + " ");
        }
    }

    /**
     * Method to preform the breadth first search algorithm which will take a
     * source label 'x' and search from said label.While a Vertex is not
     * discovered it is turned white with a distance of infinity,when it is
     * discovered but not yet visited it will turn gray and a distance set to 1
     * + the parent distance,when a vertex has been visited it will turn black
     * and set its neighbors at a distance of 1 + its distance and turn them
     * gray.
     *
     * @param x
     * @throws Exception
     */
    public void BFS(int x) throws Exception {
        Vertex s = getVertex(x);
        for (int i = 0; i < n; i++) {
            getVertex(i).setColor(Vertex.WHITE);
            getVertex(i).setDistance(999999);
            getVertex(i).setParent(null);
            if (getVertex(i).getLabel() == x) {
                s = getVertex(i);
            }
        }
        s.setColor(Vertex.GRAY);
        s.setDistance(0);
        s.setParent(null);
        Queue<Vertex> Q = new LinkedList<>();
        Q.offer(s);
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            int d = u.getDistance();
            u.setColor(Vertex.BLACK);
            for (int i = 0; i < n; i++) {
                Vertex v = getVertex(i);
                if (v.getColor() == Vertex.WHITE) {
                    v.setColor(Vertex.GRAY);
                    v.setDistance(d + 1);
                    v.setParent(u);
                    Q.offer(v);
                }
            }
        }
    }//BFS Method
}//Class
