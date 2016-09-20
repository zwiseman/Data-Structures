package trinarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This programs function is to generate a trinary search using the divide and
 * conquer method.This program will divide an array given into three separate
 * sections and recurse, that will allow the program to search through
 * each section.
 *
 * @author zacharywiseman
 */
public class TrinarySearch {

    /*---------------------------Class Methods--------------------------------*/
    /**
     * precondition: returns -1 if array is fully searched postcondition:returns
     * first or second mid point if arr[first or second] == x or recursively
     * calls trinary search if x is greater less or between the first and second
     * mid points.
     *
     * @param arr array of type int
     * @param x the integer to find
     * @param h head of array of type int
     * @param t tail of array of type int
     * @return position that an integer x is stored in an array or -1 if it is
     * not found.
     */
    public int trinarySearch(int arr[], int x, int h, int t) {
        if (h > t) {    //precondition
            System.err.println("x is not in this array");
            return -1;
        } else {
            int first = h + ((t - h) / 3);      //first mid point of array 
            int second = first + ((t - h) / 3); //second mid point of array
            if (arr[first] == x) {          //base case
                return first;
            } else if (arr[second] == x) {  //base case
                return second;
            } else if (arr[first] > x) {    //recursive case
                return trinarySearch(arr, x, 0, first - 1);          //search first third
            } else if (arr[second] < x) {   //recursive case
                return trinarySearch(arr, x, second + 1, t);         //search above second third
            } else {                        // recursive case 
                return trinarySearch(arr, x, first + 1, second - 1); //search middle
            }
        }
    }//trinarySearch

    /**
     * void method to print an array
     *
     * @param arr
     */
    public void printArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * method that will multiply two matrices and return the Strassen method of
     * matrix multiplication.
     *
     * @param arr1 int 2d array
     * @param arr2 int 2d array
     * @return Strassen algorithm method of two matrices
     */
    public int[][] matrixMultiply(int arr1[][], int arr2[][]) {
        int n = arr1.length;
        return squareMatrixMult(arr1, arr2, 0, 0, 0, 0, n);
    }//matrix

    /**
     * Strassen algorithm implementation to multiply two of the same size nxn
     * arrays recursively.
     *
     * @param arr1
     * @param arr2
     * @param arr1i array1 row
     * @param arr1j array1 column
     * @param arr2i array2 row
     * @param arr2j array2 column
     * @param size length of array 1
     * @return array of the product
     */
    public int[][] squareMatrixMult(int arr1[][], int arr2[][], int arr1i, int arr1j, int arr2i, int arr2j, int size) {
        size = arr1.length;
        //new array to store the final product
        int c[][] = new int[size][size];
        if (size == 1) {
            c[0][0] = arr1[arr1i][arr1j] * arr2[arr2i][arr2j];
        } else {

        }
        return arr1;
    }//multiplyMatrix

    /**
     * method that adds two separate 2D arrays and returns one 2d array
     *
     * @param c
     * @param a
     * @param b
     * @param Ci
     * @param Cj
     * @return c
     */
    public int[][] addMatrix(int c[][], int a[][], int b[][], int Ci, int Cj) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i + Ci][j + Cj] = a[i][j] + b[i][j];
            }
        }
        return c;
    }//addMatrix

    /**
     * method to print and format the a 2d array
     *
     * @param arr
     */
    public void print2dArray(int arr[][]) {
        for (int row = 0; row < arr.length; row++) {
            System.out.print("{");
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col][row]);
                if (col < arr.length - 1) {
                    System.out.print(", ");
                }//if
            }//col
            System.out.print("}");
            System.out.println();
        }//row
        System.out.println();
    }

    /*-----------------------------Main Method--------------------------------*/
    /**
     * Main Method
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        /*--------------------------Variables for Testing-----------------------*/
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        TrinarySearch tri = new TrinarySearch();
        Scanner sc = new Scanner(System.in);
        //trinary search arrays
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {6, 7, 8, 9, 10, 11, 15};
        int c[] = {1, 3, 5, 7, 9, 100, 101, 108};
        int d[] = {2, 4, 6, 8, 10, 11, 15, 20, 21};
        int e[] = {1, 4, 6, 8, 10, 20, 21, 23, 34, 45, 56, 67, 78, 89, 90};

        //2d arrays for multiplication method
        int arr1[][] = new int[][]{
            {1, 2},
            {1, 2}
        };
        int arr2[][] = new int[][]{
            {2, 3},
            {2, 3}
        };
        int arr3[][] = new int[arr1.length][arr1.length];

        //change values here to search for different number
        //int i = sc.nextInt();
        int v = 10;
        int w = 9;
        int x = 101;
        int y = 20;
        int z = 78;

        /*-------------------------Trinary Search Testing-------------------------*/
        //print of trinarySearch method
        //array 1
        tri.printArray(a);
        System.out.println("x = " + v);
        if (tri.trinarySearch(a, v, 0, a.length - 1) == -1) {   //do nothing if -1
        } else {
            System.out.println("x is at " + tri.trinarySearch(a, v, 0, a.length - 1));
        }
        System.out.println();

        //array 2
        tri.printArray(b);
        System.out.println("x = " + w);
        if (tri.trinarySearch(b, w, 0, b.length - 1) == -1) {   //do nothing if -1
        } else {
            System.out.println("x is at " + tri.trinarySearch(b, w, 0, b.length - 1));
        }
        System.out.println();

        //array 3
        tri.printArray(c);
        System.out.println("x = " + x);
        if (tri.trinarySearch(c, x, 0, c.length - 1) == -1) {   //do nothing if -1
        } else {
            System.out.println("x is at " + tri.trinarySearch(c, x, 0, c.length - 1));
        }
        System.out.println();

        //array 4
        tri.printArray(d);
        System.out.println("x = " + y);
        if (tri.trinarySearch(d, y, 0, d.length - 1) == -1) {   //do nothing if -1
        } else {
            System.out.println("x is at " + tri.trinarySearch(d, y, 0, d.length - 1));
        }
        System.out.println();

        //array 5
        tri.printArray(e);
        System.out.println("x = " + z);
        if (tri.trinarySearch(e, z, 0, e.length - 1) == -1) {   //do nothing if -1
        } else {
            System.out.println("x is at " + tri.trinarySearch(e, z, 0, e.length - 1));
        }
        System.out.println();

        /*-----------------------------Matrix Testing-----------------------------*/
        //addMatrix testing
        System.out.println("This is the add test for matricies: ");
        tri.print2dArray(arr1);
        tri.print2dArray(arr2);
        System.out.println("New Added Array:");
        tri.print2dArray(tri.addMatrix(arr3, arr1, arr2, 0, 0));
        //tri.print2dArray(tri.matrixMultiply(arr1, arr2));

        /*-------------------------User Testing Tinary Search---------------------*/
        //for a user to make their own trinary search array 
        String s;
        System.out.println("Would you like to make your own array to search? (y/n): ");
        s = in.readLine();
        if (s.startsWith("n") || s.startsWith("N")) {
            System.out.println("OK, we will not search an array for you ");
        }
        if (s.startsWith("y") || s.startsWith("Y")) {
            System.out.println("Enter Your Array Size: ");
            int t[] = new int[sc.nextInt()];
            System.out.println();
            System.out.println("ENTER VALUES IN NUMERICAL ORDER");
            for (int i = 0; i < t.length; i++) {
                System.out.println("Enter Array Value: ");
                t[i] = sc.nextInt();
            }
            System.out.println();
            System.out.print("Your Array:");
            tri.printArray(t);
            System.out.println("What would you like to search?");
            int search = sc.nextInt();
            System.out.println();
            if (tri.trinarySearch(t, search, 0, t.length - 1) == -1) {   //do nothing if -1
            } else {
                System.out.println("your value is at " + tri.trinarySearch(t, search, 0, t.length - 1));
            }
            System.out.println();
        }

    }//main method
}//end class
