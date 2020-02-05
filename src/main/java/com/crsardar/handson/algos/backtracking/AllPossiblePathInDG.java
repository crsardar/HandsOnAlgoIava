package com.crsardar.handson.algos.backtracking;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This prints all possible paths from a source to destination in a Directed Graph.
 *
 * @author Chittaranjan Sardar
 */
public class AllPossiblePathInDG
{

    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);

        int count = graph.findAllPath(2, 3);
        System.out.println("Total Path = " + count);
    }

    private static class Graph
    {
        // The graph is represented as a list of adjacency vertices.
        private LinkedList<Integer>[] graph;

        public Graph(final int noOfNodes)
        {
            graph = new LinkedList[noOfNodes];
            for (int i = 0; i < noOfNodes; ++i)
            {
                graph[i] = new LinkedList<>();
            }
        }

        public void addEdge(final int src, final int des)
        {
            graph[src].add(des);
        }

        public int findAllPath(final int src, final int des)
        {
            int count = 0;

            boolean visited[] = new boolean[graph.length];
            Arrays.fill(visited, false);

            Stack<Integer> path = new Stack<>();

            count = pathUtil(src, des, visited, path, 0);

            return count;
        }

        private int pathUtil(final int vertex, final int des, boolean[] visited, Stack path, int pathCount)
        {
            path.push(vertex);
            visited[vertex] = true;

            if(vertex == des)
            {
                pathCount++;

                for(int i =0; i<path.size(); i++)
                {
                    if(i < path.size() - 1)
                    {
                        System.out.print(path.get(i) + " > ");
                    }
                    else{
                        System.out.print(path.get(i));
                    }
                }
                System.out.println();
            }
            else
            {
                LinkedList adj = graph[vertex];
                Iterator iterator = adj.iterator();
                while (iterator.hasNext())
                {
                    int v = (int)iterator.next();
                    if(!visited[v])
                    {
                        pathCount = pathUtil(v, des, visited, path, pathCount);
                    }
                }
            }

            path.pop();
            visited[vertex] = false;

            return pathCount;
        }
    }
}
