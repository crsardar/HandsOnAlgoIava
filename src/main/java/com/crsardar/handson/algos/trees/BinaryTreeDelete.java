package com.crsardar.handson.algos.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDelete {
    /**
     * Algorithm
     * 1. Starting at root, find the deepest and rightmost node in binary tree and node which we want to delete.
     * 2. Replace the deepest rightmost node’s data with node to be deleted.
     * 3. Then delete the deepest rightmost node.
     */

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

        System.out.println("\nBefore delete - ");
        levelOrder();

        delete(2);

        System.out.println("\nAfter delete - ");
        levelOrder();
    }

    static void levelOrder() {

        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    static void delete(final int key) {

        if (root == null)
            return;

        Node keyNode = null;
        Node temp = null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        /**
         * Find the node to be deleted.
         * And the Highest, Right-Most node.
         *
         * After end of iteration, "temp" will have Highest, Right-Most node,
         * as it is BFS(== Level Order) traversal.
         */
        while (!q.isEmpty()) {

            temp = q.poll();

            if (temp.data == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null) {

            int tempData = temp.data;
            deleteNode(temp.data);
            keyNode.data = tempData;
        }
    }

    static void deleteNode(final int key) {

        if (root == null)
            return;

        if (root.data == key) {

            root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            Node temp = q.poll();

            if (temp.left != null) {

                if (temp.left.data == key) {

                    temp.left = null;
                    break;
                }
                q.add(temp.left);
            }

            if (temp.right != null) {

                if (temp.right.data == key) {

                    temp.right = null;
                    return;
                }

                q.add(temp.right);
            }
        }
    }
}
