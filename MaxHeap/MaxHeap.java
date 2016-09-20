package MaxHeap;

/**
 * Zack Wiseman 09/12/2016 
 * Data Structures
 * Homework #2: MaxHeap 
 * This program will take and array, turn it into a max heap then invoke
 * heapsort to return the array in sorted numerical order.
 *
 * @author zacharywiseman
 */
public final class MaxHeap {

    /*------------------------Data Fields------------------------*/
    protected final int A[];
    protected int heapsize;
    protected int largest;

    /*------------------------Constructor------------------------*/
    /**
     * constructor method to build a heap array
     *
     * @param A the array that will be created
     */
    public MaxHeap(int A[]) {
        this.A = A;
        printMaxHeap(A);
        heapsize = A.length;
        buildMaxHeap();
    }//constructor

    /*------------------------Class Methods------------------------*/
    /**
     * returns the parent of an index i
     *
     * @param i index to search for the parent from
     * @return parent of the index
     */
    protected int parentOf(int i) {
        int parent;
        parent = (i / 2) + 1;
        return A[parent];
    }

    /**
     * returns the left child of an index
     *
     * @param i index to search for left child
     * @return left child of index
     */
    protected int leftChildOf(int i) {
        int left;
        left = 2 * i + 1;
        return A[left];
    }

    /**
     * returns the right child of an index
     *
     * @param i index to search for right child
     * @return right child of index
     */
    protected int rightChildOf(int i) {
        int right;
        right = 2 * i + 2;
        return A[right];
    }

    /**
     * method taking an array type int.if the left or right child is larger than
     * the parent node then swap to turn the array into a legal max heap.
     *
     * @param i index to start from
     * @return
     */
    protected int[] maxHeapify(int i) {
        int left = 2 * i;
        int right = (2 * i) + 1;
        if (left <= heapsize - 1 && A[left] > A[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= heapsize - 1 && A[right] > A[i]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
        return A;
    }//maxHeapify

    /**
     * This method builds a max heap with the given array A.
     *
     * @return int array A as a max heap
     */
    protected int[] buildMaxHeap() {
        for (int i = ((heapsize) / 2) + 1; i >= 0; i--) {
            maxHeapify(i);
        }
        return A;
    }

    /**
     * method to implement the heapsort data structure.this method will take an
     * array and sort it using the build max heap method and max heapify
     * methods.
     *
     * @return sorted array A
     */
    public int[] heapsort() {
        int backUp = heapsize;
        buildMaxHeap();
        for (int i = heapsize - 1; i >= 0; i--) {
            swap(0, i);
            heapsize = heapsize - 1;
            maxHeapify(0);
        }
        heapsize = backUp;
        return A;
    }

    /**
     * method to swap to indices in an array
     *
     * @param x first index to swap
     * @param y second index to swap
     */
    public void swap(int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }//swap

    /**
     * Method to nicely display a heap
     *
     * @param arr
     */
    public void printMaxHeap(int arr[]) {
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
     * Method only to print the heap initialized in the constructor
     */
    public void printOriginal() {
        printMaxHeap(A);
    }
}
