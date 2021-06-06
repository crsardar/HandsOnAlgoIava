package com.crsardar.handson.algos.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chittaranjan Sardar
 */
public class GraphFormation {

    public static void main(String[] args) {

        System.out.println("Give Inputs \n");

        Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        ArrayList<ArrayList<Integer>[]> graphs = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int v = in.nextInt();
            int e = in.nextInt();

            ArrayList<Integer>[] adjl = formGraph(in, v, e);
            if (adjl != null && adjl.length > 0) {
                graphs.add(adjl);
            }
        }

        for (ArrayList<Integer>[] adjl : graphs) {

            printGraph(adjl);
        }

    }

    private static ArrayList<Integer>[] formGraph(final Scanner in, final int v, final int e) {

        final ArrayList<Integer>[] adjl = new ArrayList[v];

        for (int i = 0; i < v; i++) {

            adjl[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {

            int s = in.nextInt();
            int t = in.nextInt();
            adjl[s].add(t);
            adjl[t].add(s);
        }

        return adjl;
    }

    public static void printGraph(final ArrayList<Integer>[] adjl) {

        for (int ver = 0; ver < adjl.length; ver++) {

            ArrayList al = adjl[ver];

            if (al.size() > 0) {

                System.out.println();

                System.out.print(ver);

                for (int i = 0; i < al.size(); i++) {

                    System.out.print("->" + al.get(i));
                }
            }
        }
    }

/*
Given number of edges 'E' and vertices 'V' of a bidirectional graph. Your task is to build a graph through adjacency
list and print the adjacency list for each vertex.

Input:
The first line of input is T denoting the number of testcases.Then first line of each of the T contains two positive
integer V and E where 'V' is the number of vertex and 'E' is number of edges in graph. Next, 'E' line contains two
positive numbers showing that there is an edge between these two vertex.

Output:
For each vertex, print their connected nodes in order you are pushing them inside the list . See the  given  example.

Constraints:
1 <= T <= 200
1 <= V <= 103
1 <= E = V*(V-1)

Example:
Input:
2
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0

Output:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
0-> 1-> 2
1-> 0-> 2
2-> 1-> 0
*/
}
