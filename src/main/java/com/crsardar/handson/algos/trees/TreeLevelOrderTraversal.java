package com.crsardar.handson.algos.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print all nodes of same level in one line.
 * And nodes of different level in different lines
 */
public class TreeLevelOrderTraversal {

    static Node root;

    static class Node {

        int data;
        Node left;
        Node right;

        Node(final int data) {

            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        root = new Node(11);
        Node n1 = new Node(3);
        root.left = n1;
        n1.right = new Node(10);
        Node n2 = new Node(7);
        n1.left = n2;
        n2.left = new Node(6);
        n2.right = new Node(9);
        Node n3 = new Node(5);
        root.right = n3;
        n3.left = new Node(2);
        n3.right = new Node(8);

        levelOrder();
    }
    
    public static void levelOrder(){
        
        if(root == null)
            return;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root);

        boolean switchLevel = true;

        while (!q1.isEmpty() || !q2.isEmpty()){

            System.out.println();

            if(switchLevel){
                printLevel(q1, q2);
            } else {
                printLevel(q2, q1);
            }

            switchLevel = !switchLevel;
        }
    }

    static void printLevel(final Queue<Node> s, final Queue<Node> t){

        if(s == null || t== null){
            return;
        }

        while (!s.isEmpty()){

            Node temp = s.poll();
            System.out.print(temp.data + " ");

            if(temp.left !=null)
                t.add(temp.left);

            if(temp.right != null)
                t.add(temp.right);
        }
    }
}
