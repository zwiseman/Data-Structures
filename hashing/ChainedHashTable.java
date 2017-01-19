/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.util.LinkedList;

/**
 * Zack Wiseman 10/07/2016 Data Structures: Homework #5: ChainedHashTable This
 * class will create and manipulate a chained hash table by first constructing a
 * linked list "T" and filling it with null values then implementing the methods
 * insert, delete, and search doing the definition of the method names.
 *
 * @author zacharywiseman
 */
public class ChainedHashTable {

    /**
     * *********************************Data
     * Fields*******************************
     */
    private final LinkedList<Integer>[] T;
    private final double A = 0.6180339887;
    private int m;

    /**
     * *********************************Constructor*******************************
     */
    /**
     * Constructor that will determine "m" the first power of 2 input "n" then
     * fill the list "T" with "m" number of positions that are null in value.
     *
     * @param n number of elements to be inserted
     */
    public ChainedHashTable(int n) {
        System.out.println("n is: " + n);
        m = 1;
        while (m <= n) {
            m *= 2;
        }
        System.out.println("m is: " + m);
        System.out.println("Table Size is: " + m);
        T = new LinkedList[m];
        for (int i = 0; i < T.length; i++) {
            T[i] = new LinkedList();
        }
    }

    /**
     * ******************************Class
     * Methods********************************
     */
    /**
     * Method to insert integer into the head of the list
     *
     * @param x integer to insert
     */
    public void insert(Integer x) {
        T[hash(x)].addFirst(x);
    }

    /**
     * Method to delete integer from the hash table if found and if not found
     * then let the console know.
     *
     * @param x integer to delete
     */
    public void delete(Integer x) {
        if (T[hash(x)].removeFirstOccurrence(x) == true) {
            System.out.println("    Deleted Integer: " + x);
        } else {
            System.out.println("    Integer wasnt in table to delete: " + x);
        }
    }

    /**
     * method to search for an element in the hash table
     *
     * @param x
     * @return
     */
    public Integer search(Integer x) {
        int value = T[hash(x)].indexOf(x);
        if (value == -1) {
            return null;
        } else {
            return T[hash(x)].get(value);
        }
    }

    /**
     * Void method to print the hash table.
     */
    public void printTable() {
        System.out.print("[");
        for (int i = 0; i < T.length; i++) {
            System.out.print(T[i]);
            if (i < T.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Function of type int to take a key and run it through the multiplication
     * method of hashing to produce a value to point to a position in the hash
     * Table.
     *
     * @param key
     * @return Integer of hash function
     */
    public int hash(int key) {
        double h = m * ((key * A) % 1);
        return (int) h;
    }

}//chainedHashTable
