/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxHeap;

/**
 *
 * @author zacharywiseman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{4, 8, 1, 20, 5, 6};
        int[] c = new int[]{4, 8, 7, 2, 3};
        int[] d = new int[]{10, 128, 2, 57};
        int[] e = new int[]{34, 1502, 2341, 0};

        //Array A
        System.out.println("Original: ");
        MaxHeap heap = new MaxHeap(a);
        System.out.println("Heapsort: ");
        heap.printMaxHeap(heap.heapsort());
        System.out.println();

        //Array B
        System.out.println("Original: ");
        MaxHeap heap2 = new MaxHeap(b);
        System.out.println("Heapsort: ");
        heap2.printMaxHeap(heap2.heapsort());
        System.out.println();

        //Array C
        System.out.println("Original: ");
        MaxHeap heap3 = new MaxHeap(c);
        System.out.println("Heapsort: ");
        heap3.printMaxHeap(heap3.heapsort());
        System.out.println();

        //Array D
        System.out.println("Original: ");
        MaxHeap heap4 = new MaxHeap(d);
        System.out.println("Heapsort: ");
        heap4.printMaxHeap(heap4.heapsort());
        System.out.println();

        //Array E
        System.out.println("Original: ");
        MaxHeap heap5 = new MaxHeap(e);
        System.out.println("Heapsort: ");
        heap5.printMaxHeap(heap5.heapsort());
        System.out.println();
    }

}
