/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstnode;

/**
 * Main class for testing the classes BSTNode and BinarySearchTree
 *
 * @author zacharywiseman
 */
public class Main {

    public static void bstsort(int a[]) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < a.length; i++) {
            tree.insert(new BSTNode(a[i]));
        }
        tree.inOrder();
    }

    /**
     * Method to nicely display a heap
     *
     * @param arr
     */
    public static void printBST(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }//printMaxHeap

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int a[] = {21, 30, 10, 15, 16, 18, 22, 100, 1000, 20, 50, 30, 60, 1001, 999, 1, 2, 19, 13, 99};
        int b[] = {10,21,40,41};
        int c[] = {21,25,1,9};
        int d[] = {10,4};
        int e[] = {10000,10,1000,100};
        int f[] = {20,999,9999,100,2,10};
        
        for (int i = 0; i < a.length; i++) {
            tree.insert(new BSTNode(a[i])); //insert array elements into tree
        }
        System.out.println("**************************Traversals**********************");
        System.out.println();
        System.out.println("Pre-Order: ");
        tree.preOrder();
        System.out.println();
        System.out.println("In-Order: ");
        tree.inOrder();
        System.out.println();
        System.out.println("Post-Order: ");
        tree.postOrder();
        System.out.println();
        System.out.println("Size: " + tree.getSize());
        System.out.println();
        System.out.println();
        System.out.println("**************************Search**********************");
        System.out.println();
        System.out.println("Search 21: " + tree.search(21));
        System.out.println("Search 30: " + tree.search(30));
        System.out.println("Search 1000: " + tree.search(1000));
        System.out.println("Search 1: " + tree.search(1));
        System.out.println("Search 99: " + tree.search(99));
        System.out.println("Search 0: " + tree.search(0));
        System.out.println("Search 10000: " + tree.search(10000));
        System.out.println("Search 1002: " + tree.search(1002));
        System.out.println("Search 24: " + tree.search(24));
        System.out.println("Search 99999: " + tree.search(99999));
        System.out.println();
        System.out.println();
        System.out.println("**************************BST Sort**********************");
        System.out.println();
        System.out.println("Array 1: ");
        printBST(b);
        System.out.println("BST Sort 1: " );
        bstsort(b);
        System.out.println();
        System.out.println("Array 2: ");
        printBST(c);
        System.out.println("BST Sort 2: " );
        bstsort(c);
        System.out.println();
        System.out.println("Array 3: ");
        printBST(d);
        System.out.println("BST Sort 3: " );
        bstsort(d);
        System.out.println();
        System.out.println("Array 4: ");
        printBST(e);
        System.out.println("BST Sort 4: " );
        bstsort(e);
        System.out.println();
        System.out.println("Array 5: ");
        printBST(f);
        System.out.println("BST Sort 5: " );
        bstsort(f);
        System.out.println();
        System.out.println();
        
        System.out.println("**************************Min/Max**********************");
        System.out.println();
        System.out.println("Minimum: " + tree.minimum());
        BSTNode min = tree.minimum();
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.println(min.getKey());
            min = tree.successor(min);
        }
        System.out.println();
        BSTNode max = tree.maximum();
        System.out.println("Maximum: " + tree.maximum());
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.println(max.getKey());
            min = tree.successor(max);
        }
        System.out.println();
        System.out.println("**************************Delete**********************");
        /*
        tree.delete(tree.search(21));
        tree.delete(tree.search(30));
        tree.delete(tree.search(60));
        tree.delete(tree.search(13));
        tree.delete(tree.search(20));
        tree.delete(tree.search(18));
        tree.delete(tree.search(100));
        tree.delete(tree.search(16));
        System.out.println("Size After Delete: " + tree.getSize());
        System.out.println("In-Order After Delete: ");
        tree.inOrder();
        */
    }
    
}
