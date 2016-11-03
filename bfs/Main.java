/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

/**
 *
 * @author zacharywiseman
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        boolean[][] edges = {
            {false, true, false, false,true},
            {true, false, false, true,true},
            {false, false, false, true,false},
            {false, true, true, false,true},
            {true, true, false, true,false}
        };

        boolean[][] edges1 = {
            {false, true, false, true, false,true},
            {true, true, false, true, true,false},
            {false, false, true, false, true,false},
            {false, true, true, false, true,true},
            {true, false, false, true, true,true},
            {true, true, false, true, true,false}
        };
        
        boolean[][] edges2 = {
            {false, false, false, false, false,true,true,false},
            {true, true, true, true, true,false,true,true},
            {false, false, false, false, false,false,true,false},
            {false, true, true, true, true,true,true,false},
            {true, false, false, true, true,false,false,true},
            {false, true, true, false, true,false,true,true},
            {true, false, false, false, true,false,true,true},
            {false, true, false, true, true,false,false,true}
        };
        
        Graph graph = new Graph(edges);
        Graph graph1 = new Graph(edges1);
        Graph graph2 = new Graph(edges2);
        System.out.println("************************Graph One************************");
        graph.printGraph();
        System.out.println();
        System.out.println("Before Breadth First Search: ");
        graph.printVertex();
        graph.BFS(0);
        System.out.println();
        System.out.println("After Breadth First Search: ");
        graph.printVertex();
        System.out.println();
        System.out.println();
        
        System.out.println("***********************Graph Two*************************");
        graph1.printGraph();
        System.out.println();
        System.out.println("Before Breadth First Search: ");
        graph1.printVertex();
        graph1.BFS(0);
        System.out.println();
        System.out.println("After Breadth First Search: ");
        graph1.printVertex();
        System.out.println();
        System.out.println();
        
        System.out.println("*********************Graph Three*************************");
        graph2.printGraph();
        System.out.println();
        System.out.println("Before Breadth First Search: ");
        graph2.printVertex();
        graph2.BFS(1);
        System.out.println();
        System.out.println("After Breadth First Search: ");
        graph2.printVertex();
        System.out.println();
    }

}
