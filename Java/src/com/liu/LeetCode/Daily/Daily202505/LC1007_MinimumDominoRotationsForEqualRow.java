package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC1007_MinimumDominoRotationsForEqualRow {

    // Beats 25.38%
    private static int minDominoRotationsMy1(int[] tops, int[] bottoms) {
        int n = tops.length;
        int res = Integer.MAX_VALUE;
        int[] face = new int[7];
        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i]) {
                face[bottoms[i]]++;
            }
        }
        for (int x = 1; x <= 6; x++) {
            if (face[x] < n) {
                continue;
            }
            int maintainTop = 0;
            int maintainBottom = 0;
            for (int i = 0; i < n; i++) {
                if (tops[i] != x) maintainTop++;
                if (bottoms[i] != x) maintainBottom++;
            }
            res = Math.min(res, Math.min(maintainTop, maintainBottom));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] topsList = new int[][]{
                {2, 1, 2, 4, 2, 2},
                {3, 5, 1, 2, 3},
        };
        int[][] bottomsList = new int[][]{
                {5, 2, 6, 2, 3, 2},
                {3, 6, 3, 3, 4},
        };
        int[] resultList = new int[]{
                2,
                -1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < topsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minDominoRotationsMy1(topsList[i], bottomsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minDominoRotations My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
