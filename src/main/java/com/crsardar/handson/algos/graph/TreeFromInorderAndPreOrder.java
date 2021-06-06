package com.crsardar.handson.algos.graph;

/**
 * @author Chittaranjan Sardar
 */

public class TreeFromInorderAndPreOrder {


    public static void main(String[] arg){

        char inOrder[] = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char preOrder[] = { 'A', 'B', 'D', 'E', 'C', 'F' };

        TreeFromInorderAndPreOrder tree = new TreeFromInorderAndPreOrder();

        Node root = tree.makeTree(inOrder, preOrder, 0, preOrder.length -  1);

        tree.travarceInorder(root);

    }

    private int index = 0;

    public Node makeTree(final char[] inOrder, final char[] preOrder, final int start, final int end){

        System.out.println("index = " + index + " : start = " + start + " : end = " + end);

        if(start > end) {

            return null;
        }

        Node node = new Node(preOrder[index]);

        index = index +1;

        // Leaf node
        if(start == end){

            return node;
        }

        int inOrderIndex = find(node.data, inOrder, start, end);


        node.left = makeTree(inOrder, preOrder, start, inOrderIndex - 1);

        node.right = makeTree(inOrder, preOrder, inOrderIndex + 1, end);

        return node;
    }

    private int find(final char target, final char[] arr, final int start, final int end){

        int index = 0;

        for(int i = start; i <= end; i++){

            if(arr[i] == target){

                index = i;
                break;
            }
        }

        return index;
    }

    public static class Node{

        public char data;
        public Node left;
        public Node right;

        public Node(){

        }

        public Node(char data){

            this.data = data;
            left = null;
            right = null;
        }
    }


    public void travarceInorder(final Node root){

        if(root == null){
            return;
        }

        travarceInorder(root.left);

        System.out.println(root.data + " ");

        travarceInorder(root.right);
    }
}
