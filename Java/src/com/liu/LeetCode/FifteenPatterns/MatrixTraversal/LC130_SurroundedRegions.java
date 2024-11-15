package com.liu.LeetCode.FifteenPatterns.MatrixTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Matrix Traversal involves traversing elements in a matrix using different techniques (DFS, BFS, etc.).
 * Use this pattern for problems involving traversing 2D grids or matrices horizontally, vertically or diagonally.
 * Sample Problem:
 * Perform flood fill on a 2D grid. Change all the cells connected to the starting cell to new color.
 * Example:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * Use DFS or BFS to traverse the matrix starting from the given cell.
 * Change the color of the connected cells to the new color.
 */
public class LC130_SurroundedRegions {
    private static void solveMy1(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    if (isSurroundedMy1(board, visited, list, i, j)) {
                        for (int[] node : list) {
                            board[node[0]][node[1]] = 'X';
                        }
                    } else {
                        list.clear();
                    }
                }
                visited[i][j] = true;
            }
        }
    }

    private static boolean isSurroundedMy1(char[][] board, boolean[][] visited, List<int[]> list, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == 0 || x == row - 1 || y == 0 || y == col - 1) {
                // 在一些情况下，因为visited的标记，会导致部分位置已经被遍历过，就导致会有一些点错误的被标记为X
                // 不直接return，改为找到所有点，进行链接，返回值仅记录
                return false;
            }
            for (int[] direction : directions) {
                int newX = cur[0] + direction[0];
                int newY = cur[1] + direction[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && board[newX][newY] == 'O') {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    list.add(new int[]{newX, newY});
                }
            }
        }
        return true;
    }

    private static void solveMy2(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    if (isSurroundedMy2(board, visited, list, i, j)) {
                        for (int[] node : list) {
                            board[node[0]][node[1]] = 'X';
                        }
                    } else {
                        list.clear();
                    }
                }
                visited[i][j] = true;
            }
        }
    }

    // 基于广度优先做的，效率低于深度优先
    private static boolean isSurroundedMy2(char[][] board, boolean[][] visited, List<int[]> list, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});
        visited[i][j] = true;
        boolean result = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == 0 || x == row - 1 || y == 0 || y == col - 1) {
                result = false;
            }
            for (int[] direction : directions) {
                int newX = cur[0] + direction[0];
                int newY = cur[1] + direction[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && board[newX][newY] == 'O') {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    list.add(new int[]{newX, newY});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][][] boardSet = new char[][][]{
                {
                        {'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                        {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                        {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
                        {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                        {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'X', 'O', 'O', 'O', 'O', 'O'}
                },
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                {
                        {'X'}
                },
        };
        long startTime;
        long endTime;

        for (int i = 0; i < boardSet.length; i++) {
            startTime = System.currentTimeMillis();
            solveMy1(boardSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("solve My1 result" + i + " ");
            for (char[] node : boardSet[i]) {
                for (char c : node) {
                    System.out.print(c + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        boardSet = new char[][][]{
                {
                        {'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                        {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                        {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
                        {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                        {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                        {'O', 'X', 'O', 'O', 'O', 'O', 'O'}
                },
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                {
                        {'X'}
                },
        };
        for (int i = 0; i < boardSet.length; i++) {
            startTime = System.currentTimeMillis();
            solveMy2(boardSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("solve My1 result" + i + " ");
            for (char[] node : boardSet[i]) {
                for (char c : node) {
                    System.out.print(c + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}

