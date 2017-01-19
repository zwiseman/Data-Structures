/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramplus;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author zacharywiseman
 */
public class RAMPlus {

    /**
     * Counting sort will take an input array "A" and an output array "B" that
     * is the same length of "A" then create an array "C" size biggest element
     * in "A" which will count the number of particular elements in the array
     * such as, 3 occurrences of the value 2, and will be a guide for "B" in
     * sorted order.
     *
     * @param A input array
     * @param B unfilled array to store output
     * @param largest largest number in array
     */
    public void countingSort(int A[], int B[], int largest) {
        System.out.println("A: " + Arrays.toString(A));
        int C[] = new int[largest + 1]; //create new array C length largest+1
        for (int i = 0; i <= largest; i++) {
            C[i] = 0;       //initialize all values of C to 0
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]]++;//count instances of numbers up to largest
        }
        System.out.println("C: " + Arrays.toString(C));//print C
        for (int i = 1; i < largest + 1; i++) {
            C[i] = C[i] + C[i - 1];
        }
        System.out.println("C Directory: " + Arrays.toString(C));//print C

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];//sort by numbers in C 
            C[A[i]]--;
        }
        System.out.println("B: " + Arrays.toString(B));// print A
    }

    /**
     * selecting algorithm to find the smallest element in an unordered array
     * using the same partition method as quicksort and having a runtime
     * θ(n*log*n) and θ(n) average case and θ(n^2) worst case.
     * @param A input array
     * @param p lower bound
     * @param r upper bound
     * @param i ith order statistic
     * @return
     */
    public int randomizedQuickselect(int A[], int p, int r, int i) {
        int a[] = Arrays.copyOf(A, A.length);
        if (p == r) {
            return a[p];
        }
        Random rand = new Random();
        int z =  rand.nextInt(a.length);
        swap(a, z, r);
        int q = partition(a, p, r);
        int k = q - r + 1;
        if (i == k) {
            return a[q];
        } else if (i < k) {
            return randomizedQuickselect(a, p, q - 1, i);
        } else {
            return randomizedQuickselect(a, q + 1, r, i - k);
        }
    }

    /**
     * Helper method that divides the problem into subproblems that will also
     * swap to put the pivot choice in the right place in the subproblem.
     *
     * @param A input array
     * @param p first element of the subproblem
     * @param r pivot choice
     * @return
     */
    public int partition(int A[], int p, int r) {
        int x = A[r] - 1;
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }//partition

    /**
     * Method to swap 2 elements in an array.
     *
     * @param A the array to use
     * @param i first element to swap
     * @param j the element i is swapped with
     */
    private void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }//swap

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RAMPlus ram = new RAMPlus();
        int a[] = {0, 1, 2, 1, 2, 1, 3, 0};
        int a1[] = new int[a.length];
        int b[] = {0, 2, 1, 2, 0, 0, 1, 0, 2};
        int b1[] = new int[b.length];
        int c[] = {0, 1, 0, 2, 1, 3, 0, 4, 1, 2, 0, 4};
        int c1[] = new int[c.length];
        int d[] = {0, 1, 2, 1, 0};
        int d1[] = new int[d.length];
        int e[] = {0, 1, 0, 1, 0, 1, 0, 1};
        int e1[] = new int[e.length];

        System.out.println("Test 1:");
        ram.countingSort(a, a1, 3);
        System.out.println();

        System.out.println("Test 2:");
        ram.countingSort(b, b1, 2);
        System.out.println();

        System.out.println("Test 3:");
        ram.countingSort(c, c1, 4);
        System.out.println();

        System.out.println("Test 4:");
        ram.countingSort(d, d1, 2);
        System.out.println();

        System.out.println("Test 5:");
        ram.countingSort(e, e1, 1);
        System.out.println();

        System.out.println("Randomized Quick Select Test 1: ");
        System.out.println("original Array: " + Arrays.toString(a));
        System.out.println(ram.randomizedQuickselect(a, 0, a.length - 1, 0));
        System.out.println();

        System.out.println("Randomized Quick Select Test 2: ");
        System.out.println("original Array: " + Arrays.toString(b));
        System.out.println(ram.randomizedQuickselect(b, 0, b.length - 1, 0));
        System.out.println();
        
        System.out.println("Randomized Quick Select Test 3: ");
        System.out.println("original Array: " + Arrays.toString(c));
        System.out.println(ram.randomizedQuickselect(c, 0, c.length - 1, 0));
        System.out.println();

        System.out.println("Randomized Quick Select Test 4: ");
        System.out.println("original Array: " + Arrays.toString(d));
        System.out.println(ram.randomizedQuickselect(d, 0, d.length - 1, 0));
        System.out.println();

        System.out.println("Randomized Quick Select Test 5: ");
        System.out.println("original Array: " + Arrays.toString(e));
        System.out.println(ram.randomizedQuickselect(e, 0, e.length - 1, 1));
        System.out.println();
        
        
        System.out.println("may give error depending on choie of random variable");
    }
}
