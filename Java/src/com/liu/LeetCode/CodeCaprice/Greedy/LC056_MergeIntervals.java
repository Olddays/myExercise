package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.*;

public class LC056_MergeIntervals {

    // Beats 49.15%
    private static int[][] mergeMy1(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int[] cache = intervals[0];
        for (int i = 1; i < length; i++) {
            if (cache[1] >= intervals[i][0]) { // 合并
                cache[1] = Math.max(cache[1], intervals[i][1]);
            } else {
                result.add(cache);
                cache = intervals[i];
            }
        }
        result.add(cache);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][][] intervalsList = new int[][][]{
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}},
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < intervalsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = mergeMy1(intervalsList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("merge My1 result" + i + " ");
            for (int[] line : result) {
                for (int val : line) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
