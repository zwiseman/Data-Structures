/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.util.Objects;

/**
 * Zack Wiseman 10/07/2016 Data Structures: Homework #5: OpenAddressedHashTable
 * This class will create and manipulate a open addressed hash table by first
 * constructing a linked list "T" and filling it with null values then
 * implementing the methods insert, delete, and search doing the definition of
 * the method names.
 *
 * @author zacharywiseman
 */
public class OpenAddressedHashTable {

    /**
     * ******************************DataFields*******************************
     */
    private final Integer[] T;
    private final double A = 0.6180339887;
    private final int deleted = Integer.MIN_VALUE;
    int m;

    /**
     * *********************************Constructor*******************************
     */
    /**
     * Constructor that will determine "m" the first power of 2 input "n" then
     * fill the list "T" with "m" number of positions that are null in value.
     *
     * @param n
     */
    public OpenAddressedHashTable(int n) {
        System.out.println("n is: " + n);
        m = 1;
        while (m <= n) {
            m *= 2;
        }
        System.out.println("m is: " + m);
        T = new Integer[m];
    }

    /**
     * ******************************Class
     * Methods********************************
     */
    /**
     * Method to insert integer into the head of the list
     *
     * @param x
     * @return
     */
    public Integer insert(Integer x) {
        Integer k = x;
        for (Integer i = 0; i < m; i++) {
            Integer j = hash(k, i);
            if (T[j] == null) {
                T[j] = x;
                return j;
            }
        }
        System.err.println("Hash table overflow");
        return null;
    }

    /**
     * method to delete an element from the table
     *
     * @param x int to delete
     * @return very small number in deleted space
     */
    public Integer delete(Integer x) {
        Integer k = x;
        for (Integer i = 0; i < m; i++) {
            Integer j = hash(k, i);
            if (Objects.equals(T[j], k)) {
                T[j] = deleted;
                return j;
            }
        }
        System.err.println("Element not found");
        return null;
    }

    /**
     * Method to search for an integer x
     *
     * @param x search element
     * @return element if it is in the table if not then null
     */
    public Integer search(Integer x) {
        for (Integer i = 0; i < m; i++) {
            Integer j = hash(x, i);
            if (T[j] == null) {
                return null;
            }
            if (Objects.equals(T[j], x)) {
                return T[j];
            }
        }
        return null;
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

    public int hash(int key, int i) {
        int h = (hash(key) + i) % m;
        return h;
    }
}
