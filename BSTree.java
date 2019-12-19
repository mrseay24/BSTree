package BSTree;

/*
CSC3410 - Fall 2015
Sidney Seay -  sseay5@student.gsu.edu

Assignment: #7

BSTree class

File(s): BSTree.java

Purpose: To gain experience with Binary Search Trees and utilizing Linked List.
         
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class BSTree {
    
    // constructor
    public BSTree() {
        this.nodeRoot = null;
    }
    // reference random number generator
	static Random bSTree = new Random();
    // Linked List	
    static LinkedList<Integer > iNumber = new LinkedList();
    static LinkedList<Integer > linkedListBST = new LinkedList();    
    static TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>();
    static nodeBST nodeRoot;
    
    /*
    *  class node binary search tree
    */
    class nodeBST
    {
        int data;
        nodeBST parent;
        nodeBST left;
        nodeBST right;

        nodeBST(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        nodeBST()
        {
        }
    }
    /*
    *  insert node in binary search tree    
    */
    void insertNode(nodeBST node, int data)
    {
    	// check the root node
        if (node == null)
        {
            node = new nodeBST(data);
            nodeRoot = node;
        }
    	// check the left node
        else if (data < node.data && node.left == null)
        {
            node.left = new nodeBST(data);
            node.left.parent = node;
        }
    	// check the right node        
        else if (data >= node.data && node.right == null)
        {
            node.right = new nodeBST(data);
            node.right.parent = node;
        }
        else
        {
        	// should we insert left node        	
            if (data < node.data)
            {
                insertNode(node.left, data);
            }
            else // should we insert right node
            {
                insertNode(node.right, data);
            }
        }
    }    
   /*
   *     
   */
   static void inOrder(nodeBST node)
   {
        if (node != null)
        {
            // recursive call to method inOrder
        	inOrder(node.left);
            System.out.print(node.data + " - ");
            inOrder(node.right);
        }
   }    
   /*
   * Create linked list of random generated number   
   */
   static void createLinkedListRandomNumber() {
   	   int iRandom = 0;

       for (int i = 1; i <= 100; i++) {
        	 iRandom = bSTree.nextInt(100);
        	 iNumber.add(iRandom);
      }
       // display linked list random numbers
       System.out.println("Linked list of random generated number: " + iNumber.toString());
   }
   /*
   * Build binary search tree from linked list of random generated number   
   */
   static void buildBinarySearchTreeFromLinkedList() {
       // create instance of class BSTree
	   BSTree bTree = new BSTree();

	   int dup = 0;
       for (int i = 0; i < iNumber.size(); i++) {
             if (!tMap.containsKey(iNumber.get(i))) {
            	 // key, value
                 tMap.put(iNumber.get(i), iNumber.get(i));
            	 // insert node in binary search tree
                 bTree.insertNode(bTree.nodeRoot, iNumber.get(i));            	 
             }
             else {
            	 dup++;
             }
       }
       System.out.println("Total duplicate random generated number bypassed: " + dup);       
   }
   
   /*
   * M A I N
   */
   public static void main(String[] args){
       // create linked list random numbers 
	   createLinkedListRandomNumber();
       // build binary search tree from linked list random numbers 
	   buildBinarySearchTreeFromLinkedList();
       // print binary search tree        
       System.out.println("Binary Search Tree is");
	   inOrder(nodeRoot);
   }
}