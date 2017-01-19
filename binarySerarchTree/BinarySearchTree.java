/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstnode;

/**
 *
 * @author zacharywiseman
 */
public class BinarySearchTree {

    private BSTNode root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /*******************************Dynamic Set Operations*********************/
    /**
     *method to insert a value into a BST while incrementing the size each value
     * inserted.
     * 
     * @param z
     * @return inserted element z
     */
    public BSTNode insert(BSTNode z) {
        BSTNode y = null;
        BSTNode x = root;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setP(y);
        if (y == null) {
            root = z;
            size++;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
            size++;
        } else {
            y.setRight(z);
            size++;
        }
        return z;
    }

    /**
     * method to delete a value from a BST and decrement the size.
     * @param z
     * @return node z
     */
    public BSTNode delete(BSTNode z) {
        if (z.getLeft() == null) {
            transplant(z, z.getRight());
        } else if (z.getRight() == null) {
            transplant(z, z.getLeft());
        } else {
            BSTNode y = minimum(z.getRight());
            if (y.getP() != z) {
                transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setP(y);
            }
            transplant(z, y);
            y.getLeft().setP(y);
        }
        size--;
        return z;
    }

    public BSTNode search(int k){
        return search(root,k);
    }
    /**
     * Search for the key k in the tree
     *
     * @param root
     * @param k
     * @return
     */
    public BSTNode search(BSTNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == root.getKey()) {
            return root;
        }
        if (k < root.getKey()) {
            return search(root.getLeft(), k);
        } else {
            return search(root.getRight(), k);
        }
    }

    /**
     * Method that will return the minimum element if there is one of x
     *
     * @param x
     * @return minimum value
     */
    private BSTNode minimum(BSTNode x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }
    /**
     * method to run minimum
     * @return 
     */
    public BSTNode minimum(){
        return minimum(root);
    }
    /**
     * Method that will return the maximum element if there is one of x
     *
     * @param x
     * @return maximum value
     */
    private BSTNode maximum(BSTNode x) {
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }
    
    /**
     * Method to run maximum
     * @return 
     */
    public BSTNode maximum(){
        return maximum(root);
    }

    /**
     * Method that will take a node and return the successor
     *
     * @param x node
     * @return successor of x
     */
    public BSTNode successor(BSTNode x) {
        if (x.getRight() != null) {
            return minimum(x.getRight());
        }
        while (x.getP() != null && x == x.getP().getRight()) {
            x = x.getP();
        }
        return x.getP();
    }

    /**
     * Method that will take a node and return the predecessor
     *
     * @param x node
     * @return predecessor of x
     */
    public BSTNode predecessor(BSTNode x) {
        if (x.getLeft() != null) {
            return maximum(x.getLeft());
        }
        while (x.getP() != null && x == x.getP().getLeft()) {
            x = x.getP();
        }
        return x.getP();
    }

    /********************************Traversal Methods*************************/
    /**
     * Method to traverse the tree in a pre order visiting the parents then the
     * children
     *
     * @param node
     */
    private void preOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.getKey());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * Method to traverse the tree moving in order visiting the left child,
     * parent, then right child
     *
     * @param node
     */
    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getKey());
            inOrder(node.getRight());
        }
    }

    /**
     * Method to traverse the tree moving in post order visit in the children
     * first then the parent
     *
     * @param node
     */
    private void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getKey());
        }
    }
    
    /**
     * runner for pre order traversal at the root
     */
    public void preOrder(){
        preOrder(root);
    }
    
    /**
     * runner for in order traversal at the root
     */
    public void inOrder(){
        inOrder(root);
    }
    
    /**
     * runner for post order traversal at the root 
     */
    public void postOrder(){
        postOrder(root);
    }

    /****************************Helper Methods********************************/
    /**
     * Helper method for delete
     *
     * @param u node
     * @param v node
     */
    private void transplant(BSTNode u, BSTNode v) {
        if (u.getP() == null) {
            root = v;
        } else if (u == u.getP().getLeft()) {
            u.getP().setLeft(v);
        } else {
            u.getP().setRight(v);
        }
        if (v != null) {
            v.setP(u.getP());
        }
    }
/***********************************Getter Method******************************/
    /**
     * Getter method for size
     * @return  size 
     */
    public int getSize(){
        return size;
    }
    
}
