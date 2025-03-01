package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.Arrays;

public class LC455_AssignCookies {

    // Beats 99.57%
    private static int findContentChildrenMy1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }

    public static void main(String[] args) {
        int[][] gList = new int[][]{
                {1, 2, 3},
                {1, 2},
        };
        int[][] sList = new int[][]{
                {1, 1},
                {1, 2, 3},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < gList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findContentChildrenMy1(gList[i], sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findContentChildren My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
