/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author zacharywiseman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /************************ChainedHashTable**********************************/
        System.out.println("Chained Hash Table: ");
        System.out.println();
        ChainedHashTable hash = new ChainedHashTable(20);
        System.out.println();
        System.out.println("Before Insert: ");
        hash.printTable();
        hash.insert(2);
        hash.insert(2);
        hash.insert(5);
        hash.insert(6);
        hash.insert(10);
        hash.insert(30);
        hash.insert(30);
        hash.insert(12);
        hash.insert(7);
        hash.insert(12);
        hash.insert(15);
        hash.insert(22);
        hash.insert(21);
        hash.insert(21);
        hash.insert(24);
        hash.insert(24);
        hash.insert(27);
        hash.insert(3);
        hash.insert(8);
        hash.insert(9);
        System.out.println();
        System.out.println("After Insert: ");
        hash.printTable();
        System.out.println();
        System.out.println("Integers Deleted If Found Below: ");
        hash.delete(2);
        hash.delete(8);
        hash.delete(24);
        hash.delete(15);
        hash.delete(30);
        hash.delete(1);
        System.out.println();
        System.out.println("Table After Delete: ");
        hash.printTable();
        System.out.println();
        System.out.println("Search Functions Returned: " + hash.search(0));
        System.out.println("Search Functions Returned: " + hash.search(21));
        System.out.println("Search Functions Returned: " + hash.search(30));
        System.out.println("Search Functions Returned: " + hash.search(2));
        System.out.println("Search Functions Returned: " + hash.search(12));
        System.out.println();
    /***********************OpenAddressedHashTable*****************************/
        System.out.println("Open Addressed Hash Table");
        System.out.println();
        OpenAddressedHashTable open = new OpenAddressedHashTable(20);
        open.insert(24);
        open.insert(24);
        open.insert(21);
        open.insert(31);
        open.insert(13);
        open.insert(14);
        open.insert(12);
        open.insert(20);
        open.insert(21);
        open.insert(12);
        open.insert(31);
        open.insert(39);
        open.insert(41);
        open.insert(31);
        open.insert(21);
        open.insert(5);
        open.insert(8);
        open.insert(6);
        open.insert(20);
        open.insert(80);
        System.out.println("After Insert: ");
        open.printTable();
        System.out.println();
        open.delete(21);
        open.delete(31);
        open.delete(24);
        open.delete(39);
        open.delete(41);
        System.out.println("After Delete: ");
        open.printTable();
        System.out.println();
        System.out.println("Search Functions Returned: " + open.search(80));
        System.out.println("Search Functions Returned: " + open.search(21));
        System.out.println("Search Functions Returned: " + open.search(24));
        System.out.println("Search Functions Returned: " + open.search(6));
        System.out.println("Search Functions Returned: " + open.search(99));
    }

}
