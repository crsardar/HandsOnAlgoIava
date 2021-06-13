package com.crsardar.handson.algos.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Breath First Search Traversal of a graph.
 * This is a DG.
 */

public class GraphBFS {

    private final int noVertices;
    private final ArrayList<ArrayList<Integer>> adjm = new ArrayList<>();

    GraphBFS(int noVertices) {

        this.noVertices = noVertices;
        if (noVertices <= 0) {
            throw new RuntimeException("A graph must have at least one node.");
        }
        for (int i = 0; i < noVertices; i++) {
            adjm.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {

        GraphBFS graphBFS = new GraphBFS(4);

        graphBFS.addEdge(0, 1);
        graphBFS.addEdge(0, 2);
        graphBFS.addEdge(1, 2);
        graphBFS.addEdge(2, 0);
        graphBFS.addEdge(2, 3);
        graphBFS.addEdge(3, 3);

        graphBFS.doBFSTraversal(2);
    }

    public void addEdge(int src, int des) {

        adjm.get(src).add(des);
    }

    public void doBFSTraversal(final int src) {

        if (adjm.size() <= 0) {
            System.out.println("The graph is empty.");
            return;
        }

        boolean isVisited[] = new boolean[noVertices];
        for (int i = 0; i < noVertices; i++)
            isVisited[i] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        System.out.println("\tThe BFS traversal of the graph -\n\t");

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            // Print
            System.out.print(curr + " ");

            // Mark visited.
            isVisited[curr] = true;

            // Check for adjacent edges.
            ArrayList<Integer> adjEdges = adjm.get(curr);
            for (int e : adjEdges) {

                // If not visited, enqueue it(cycle detection).
                if (!isVisited[e]) {
                    queue.add(e);
                }
            }
        }

        System.out.println();
    }
}
