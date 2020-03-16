package com.crsardar.handson.algos.backtracking;

/**
 * Print path of movement of a Rat in a NxN matrix maze, where 0 in a cell means dead block.
 * Rat can move only towards Right and Down.
 *
 * @author Chittaranjan Sardar
 */
public class RatInAMaze {

    private static int N;

    public static void main(String[] args) {

        int maze[][] =
                {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        N = maze.length;

        int sol[][] = new int[N][N];

        if (moveRat(0, 0, maze, sol)) {
            printSol(sol);
        } else {
            System.out.println("No Solution Present!");
        }
    }

    private static boolean moveRat(final int x, final int y, final int[][] maze, final int[][] sol) {

        if (x == N - 1 && y == N - 1) {

            sol[x][y] = 1;
            return true;
        }

        if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1) {

            sol[x][y] = 1;

            if (moveRat(x, y + 1, maze, sol))
                return true;

            if (moveRat(x + 1, y, maze, sol))
                return true;

            sol[x][y] = 0;
        }

        return false;
    }

    private static void printSol(final int[][] sol) {
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
        }
    }
}
