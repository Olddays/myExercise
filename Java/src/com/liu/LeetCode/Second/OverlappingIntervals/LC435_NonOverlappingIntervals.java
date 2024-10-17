package com.liu.LeetCode.Second.OverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class LC435_NonOverlappingIntervals {
    private static int eraseOverlapIntervalsMy1(int[][] intervals) { // accepted 性能较差
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        int[] start = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (start[1] <= current[0]) {
                start = current;
            } else {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] intervalsSet = new int[][][]{
                {{1, 2}, {2, 3}, {3, 4}, {1, 3}},
                {{1, 2}, {1, 2}, {1, 2}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < intervalsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = eraseOverlapIntervalsMy1(intervalsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("eraseOverlapIntervals My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
