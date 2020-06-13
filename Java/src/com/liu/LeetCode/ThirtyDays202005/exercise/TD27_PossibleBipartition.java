package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/28.
 */
public class TD27_PossibleBipartition {
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] relationGraph = new int[N][N];
        for (int[] d : dislikes) {
            relationGraph[d[0] - 1][d[1] - 1] = 1;
            relationGraph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] groupRecord = new int[N];
        for (int num = 0; num < N; num++) {
            if (groupRecord[num] == 0 && !dfs(relationGraph, groupRecord, num, 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] relationGraph, int[] groupRecord, int num, int groupNum) {
        groupRecord[num] = groupNum;
        for (int friendIndex = 0; friendIndex < relationGraph.length; friendIndex++) {
            if (relationGraph[num][friendIndex] == 1) {
                if (groupRecord[friendIndex] == groupNum) {
                    return false;
                }
                if (groupRecord[friendIndex] == 0 && !dfs(relationGraph, groupRecord, friendIndex, -groupNum)) {
                    return false;
                }
            }
        }
        return true;
    }
}
