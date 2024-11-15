package com.liu.LeetCode.FifteenPatterns.MatrixTraversal;

import java.util.*;

public class LC733_FloodFill {

    private static int[][] floodFillMy1(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        image[sr][sc] = color;
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && image[newX][newY] == oldColor) {
                    image[newX][newY] = color;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][][] imageSet = new int[][][]{
                {{0, 0, 0}, {0, 0, 0}},
                {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
                {{0, 0, 0}, {0, 0, 0}},
        };
        int[] srSet = new int[]{
                1,
                1,
                1,
        };
        int[] scSet = new int[]{
                1,
                1,
                0,
        };
        int[] colorSet = new int[]{
                0,
                2,
                2,
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < imageSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = floodFillMy1(imageSet[i], srSet[i], scSet[i], colorSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("floodFill My1 result" + i + " ");
            for (int[] nums : result) {
                for (int num : nums) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}