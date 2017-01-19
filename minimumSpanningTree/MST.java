/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mst;

/**
 * Zack Wiseman
 * Data Structures
 * Homework#8: MST 
 * @author zacharywiseman
 */
public class MST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Edge[][] edge1 = {
            {new Edge(),new Edge(4),new Edge(2),new Edge(6),new Edge()},
            {new Edge(4),new Edge(),new Edge(1),new Edge(7),new Edge()},
            {new Edge(2),new Edge(1),new Edge(),new Edge(2),new Edge(3)},
            {new Edge(6),new Edge(7),new Edge(2),new Edge(),new Edge(5)},
            {new Edge(),new Edge(),new Edge(3),new Edge(5),new Edge()},
        };
        
        Edge[][] edge2 = {
            {new Edge(),new Edge(),new Edge(),new Edge(6),new Edge(2)},
            {new Edge(),new Edge(),new Edge(),new Edge(4),new Edge(3)},
            {new Edge(),new Edge(),new Edge(),new Edge(),new Edge(1)},
            {new Edge(6),new Edge(4),new Edge(),new Edge(),new Edge(1)},
            {new Edge(2),new Edge(3),new Edge(1),new Edge(1),new Edge()},
        };
        
        Graph graph = new Graph(edge1);
        Graph graph1 = new Graph(edge2);
        System.out.println("****************Graph 1*************** ");
        graph.primMst();
        graph.printGraph();
        System.out.println();
        graph.printVerticies();
        System.out.println();
        System.out.println();
        
        System.out.println("****************Graph 2**************** ");
        graph1.primMst();
        graph1.printGraph();
        System.out.println();
        graph1.printVerticies();
    }
    
}
