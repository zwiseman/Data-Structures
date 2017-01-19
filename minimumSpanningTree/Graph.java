/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mst;

import java.util.PriorityQueue;

/**
 *
 * @author awhitley
 */
public class Graph {
    /****************************Data Fields***********************************/
    private final Vertex[] vert; 
    private final int n;
    private final Edge[][] edges;
    
    /*****************************Constructor**********************************/
    /**
     * 
     * @param edges 
     */
    public Graph(Edge[][] edges){
        this.edges = edges;
        this.n = edges.length;
        this.vert = new Vertex[n];
        for(int i = 0;i < n; i++){
            vert[i] = new Vertex(i,Edge.INFINITE_WEIGHT);
        }
    }
    
    /***************************Getter Methods*********************************/
    /**
     * Getter method for n
     * @return n which is the size of the graph, presumably square.
     */
    public int getN(){
        return n;
    }
    
    /**
     * Getter method for vertex 'i' 
     * @param i
     * @return vertex you are wanting to get
     */
    public Vertex getVertex(int i){
        return vert[i];
    }
    
    /**
     * Getter method for edges
     * @param n
     * @param x
     * @return edges 
     */
    public Edge[][] getEdge(int n, int x){
        return edges;
    }
    
    /***************************Class Methods**********************************/
    /**
     * Method to print vertices for testing 
     */
    public void printVerticies(){
        for (int i = 0; i < n; i++) {
            System.out.println(vert[i] + " ");
        }
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
     * void method to perform prims MST and calculate a minimum spanning tree
     */
    public void primMst(){
        Vertex s = vert[0];//source vertex
        for(Vertex u : vert){
           u.setKey(Edge.INFINITE_WEIGHT);
           u.setParent(null);
        }
        s.setKey(0);
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        for(int i =0; i<n;i++){
            Q.add(vert[i]);
        }
        while(!Q.isEmpty()){
            s = Q.poll();
            for(int i = 0;i<n;i++){
                if (edges[s.getLabel()][i].getExists()){
                    if(isStillInQ(Q,vert[i].getLabel()) && edges[s.getLabel()][i].getWeight() < vert[i].getKey()){
                        vert[i].setParent(s);
                        decreaseKey(Q,vert[i].getLabel(),edges[s.getLabel()][i].getWeight());
                    }
                }
            }
        }
    }
    
    
    
    /************************Private Helper Methods****************************/
    /**
     * Tells you whether a Vertex with the provided label is still in the queue
     * q.This is needed because, since the PriorityQueue is keyed on key not
     * label, it will tell you whether a given key is still in it, but not
     * whether a given label is still in it.
     *
     * @param q a PriorityQueue<Vertex>
     * @param label The Vertex label to check for.
     * @return Returns true if a Vertex with matching label is in q. Returns
     * false if no Vertex with matching label is in q.
     */
    private boolean isStillInQ(PriorityQueue<Vertex> q, int label) {

        Vertex[] array = q.toArray(new Vertex[0]); // dump out an array of the elements

        // traverse the array of elements, searching for a matching label
        for (int i = 0; i < array.length; i++) {
            if ((array[i]).getLabel() == label) {
                return true;
            }
        }
       
        return false; // no matching label found

    }//isStillInQ

    /**
     * Takes the Vertex with matching label in queue q, and reduces its key to
     * newKey.Will return false if Vertex is not in the queue, or newKey is
     * larger than old key.Will return true if it successfully reduced the key.
     *
     * @param q The priority queue of Vertex
     * @param label The label of the Vertex whose key you want to decrease
     * @param newKey
     * @return Returns false if the Vertex with the given label is not in the
     * queue. Returns false if the newKey is larger than the old key of Vertex
     * with given label. Returns true otherwise; the vertex with the given label
     * had its key changed to newKey.
     */
    private boolean decreaseKey(PriorityQueue<Vertex> q, int label, int newKey) {
        // PAY NO ATTENTION TO THE CODE BEHIND THAT CURTAIN! ;)
        // Don't worry about the code in this method body. Read the Javadoc above.

        int indexOfVertex = -1;
        Vertex[] array = q.toArray(new Vertex[0]);

        // check to see if Vertex with the given label is in the Priority queue.
        for (int i = 0; i < array.length; i++) {
            if ((array[i]).getLabel() == label) {
                indexOfVertex = i;
            }
        }

        // if Vertex with the given label is not in the queue, do nothing and return false
        // also returns false if the new key is larger than the old key.
        if (indexOfVertex == -1 || newKey > array[indexOfVertex].getKey()) {
            return false;
        }

        // Without decreaseKey already in the PriorityQueue class,
        // I must remove the vertex and add it again with a different key. 
        // Actually, I'm emptying the queue, then I am inserting all the other
        // vert back in, except the one being decreased. Then I am reinserting
        // the decreased vertex, with the newKey key value.
        // I had to resort to this because technically you can't remove 
        // an element from a PriorityQueue by its label, since it is keyed on something else.
        Vertex vertexToDecrease = array[indexOfVertex];
        vertexToDecrease.setKey(newKey);

        // clear and rebuild the priority queue
        q.clear();
        for (int i = 0; i < array.length; i++) { // add everything else
            if (i != indexOfVertex) { // not including the old vertex to be reduced
                q.add(array[i]);
            }
        }
        q.add(vertexToDecrease); // insert the decreased vertex back in

        return true; // queue is now effectively identical to before, but with one Vertex's key reduced to newKey
    }//decreaseKey
}//class
