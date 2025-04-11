package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC3394_CheckIfGridCanBeCutIntoSections {

    // 两次水平或垂直切割，并且确保分割不会切碎rectangles，也就是说问x轴或y轴是否有三个无重叠
    // 分别判断x轴和y轴是否无重叠
    // 并且，不能切在边界上，否则就无法分出三个区域
    // Beats 25.00%
    private static boolean checkValidCutsMy1(int n, int[][] rectangles) {
        int length = rectangles.length;
        // x轴
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int lastLocate = 1;
        for (int[] rectangle : rectangles) {
            int xStart = rectangle[0];
            int xEnd = rectangle[2];
            if (lastLocate <= xStart) {
                count++;
            }
            lastLocate = Math.max(lastLocate, xEnd);
        }
        if (count >= 2) {
            return true;
        }
        // y轴
        count = 0;
        lastLocate = 1;
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[1]));
        for (int[] rectangle : rectangles) {
            int yStart = rectangle[1];
            int yEnd = rectangle[3];
            if (lastLocate <= yStart) {
                count++;
            }
            lastLocate = Math.max(lastLocate, yEnd);
        }
        return count >= 2;
    }

    // 逻辑没错，那就要优化
    // 不使用Comparator.comparingInt，能从Beats 25.00%到87.72%
    private static boolean checkValidCutsMy2(int n, int[][] rectangles) {
        int length = rectangles.length;
        // x轴
        Arrays.sort(rectangles, (a,b) -> a[0] - b[0]);
        int count = 0;
        int lastLocate = rectangles[0][2];
        for (int i = 1; i < length; i++) {
            if (lastLocate <= rectangles[i][0]) {
                count++;
            }
            lastLocate = Math.max(lastLocate, rectangles[i][2]);
        }
        if (count >= 2) {
            return true;
        }
        // y轴
        Arrays.sort(rectangles, (a,b) -> a[1] - b[1]);
        count = 0;
        lastLocate = rectangles[0][3];
        for (int i = 1; i < length; i++) {
            if (lastLocate <= rectangles[i][1]) {
                count++;
            }
            lastLocate = Math.max(lastLocate, rectangles[i][3]);
        }
        return count >= 2;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                5,
                4,
                4,
        };
        int[][][] rectanglesList = new int[][][]{
                {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}},
                {{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}},
                {{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = checkValidCutsMy1(nList[i], rectanglesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("checkValidCuts My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = checkValidCutsMy2(nList[i], rectanglesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("checkValidCuts My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
