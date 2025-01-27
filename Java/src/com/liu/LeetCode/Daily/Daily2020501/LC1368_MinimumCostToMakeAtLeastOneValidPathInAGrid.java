package com.liu.LeetCode.Daily.Daily2020501;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1368_MinimumCostToMakeAtLeastOneValidPathInAGrid {
    private static class Tuple {
        int row, col, cost;

        public Tuple(int r, int c, int co) {
            row = r;
            col = c;
            cost = co;
        }
    }

    // Dijkstra
    private static int minCostAnswer1(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int targetRow = grid.length - 1, targetColumn = grid[0].length - 1;

        boolean[][] traversed = new boolean[rows][columns];
        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));

        pq.add(new Tuple(0, 0, 0));

        while (!pq.isEmpty()) {
            Tuple top = pq.poll();
            int row = top.row, col = top.col;
            traversed[row][col] = true;
            if (row == targetRow && col == targetColumn) {
                return top.cost;
            }
            // traverse neighbors
            if (col + 1 != columns && !traversed[row][col + 1]) {
                pq.add(new Tuple(row, col + 1, (grid[row][col] == 1 ? 0 : 1) + top.cost));
            }

            if (col - 1 != -1 && !traversed[row][col - 1]) {
                pq.add(new Tuple(row, col - 1, (grid[row][col] == 2 ? 0 : 1) + top.cost));
            }

            if (row + 1 != rows && !traversed[row + 1][col]) {
                pq.add(new Tuple(row + 1, col, (grid[row][col] == 3 ? 0 : 1) + top.cost));
            }

            if (row - 1 != -1 && !traversed[row - 1][col]) {
                pq.add(new Tuple(row - 1, col, (grid[row][col] == 4 ? 0 : 1) + top.cost));
            }

        }
        return 0;
    }

    private static int minCostAnswer2(int[][] grid) {
        final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;

        int[][] costs = new int[m][n];
        for (int[] c : costs) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        // min-heap storing triplets 0f {x, y, cost to reach (x,y) from (0,0)}
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[]{0, 0, 0});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int x = curr[0], y = curr[1], cost = curr[2];

            if (x == m - 1 && y == n - 1) {
                return cost;
            }
            for (int i = 0; i < 4; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x + dir[0], newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;

                int newCost = cost + (i + 1 == grid[x][y] ? 0 : 1);
                if (costs[newX][newY] > newCost) {
                    costs[newX][newY] = newCost;
                    heap.offer(new int[]{newX, newY, newCost});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] gridList = new int[][][]{
                {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}},
                {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}},
                {{1, 2}, {3, 4}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minCostAnswer1(gridList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minCost Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < gridList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minCostAnswer2(gridList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minCost Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
