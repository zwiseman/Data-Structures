/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstnode;

/**
 * Class to create a node for the binary search trees with getter and setter
 * methods to get and set nodes. 
 * @author zacharywiseman
 */
public class BSTNode {
    private final int key;
    private BSTNode p;
    private BSTNode left;
    private BSTNode right;
/****************************Constructor***************************************/
    /**
     * Constructs a node with empty subtree with a value equal to key
     * @param key 
     */
    public BSTNode(int key){
        this.key = key;
        p = null;
        left = null;
        right = null;
    }
    
/***************************Get Methods*************************************/
    /** 
     * Get method for key
     * @return key
     */
    public int getKey(){
        return key;
    }
    /**
     * Get Method for p
     * @return p
     */
    public BSTNode getP(){
        return p;
    }
    /**
     * Get method for left
     * @return left
     */
    public BSTNode getLeft(){
        return left;
    }
    /**
     * Get Method for right
     * @return right
     */
    public BSTNode getRight(){
        return right;
    }
/*****************************Set Methods**************************************/
    /**
     * Set method for p
     * @param p 
     */
    public void setP(BSTNode p){
        this.p = p;
    }
    /**
     * Set method for left
     * @param left 
     */
    public void setLeft(BSTNode left){
        this.left = left;
    }
    /**
     * Set method for right
     * @param right 
     */
    public void setRight(BSTNode right){
        this.right = right;
    }
    
}
