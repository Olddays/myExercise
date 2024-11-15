package com.liu.LeetCode.FifteenPatterns.MatrixTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class LC200_NumberOfIslands {
    // accepted 但性能不是很高
    private static int numIslandsMy1(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] direction : directions) {
                            int x = cur[0] + direction[0];
                            int y = cur[1] + direction[1];
                            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                                grid[x][y] = '0'; // 如果不改0，改成增加一個Boolean数组的方式，可以减少遍历的次树
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][][] gridSet = new char[][][]{
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                },
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                },
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = numIslandsMy1(gridSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numIslands My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
