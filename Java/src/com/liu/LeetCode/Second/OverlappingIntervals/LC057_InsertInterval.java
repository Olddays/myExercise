package com.liu.LeetCode.Second.OverlappingIntervals;

import java.util.*;

public class LC057_InsertInterval {

    private static int[][] insertMy1(int[][] intervals, int[] newInterval) { // accepted 性能很差
        List<int[]> cache = new ArrayList<>();
        Collections.addAll(cache, intervals);
        cache.add(newInterval);
        cache.sort(Comparator.comparingInt(o -> o[0]));
        int[] previous = cache.get(0);
        int i = 1;
        while (i < cache.size()) {
            int[] current = cache.get(i);
            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
                cache.remove(current);
            } else {
                previous = current;
                i++;
            }
        }
        return cache.toArray(new int[cache.size()][]);
    }

    private static int[][] insertAnswer1(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> output = new ArrayList<>();
        // 根据题目，在newInterval加入前，intervals里面没有重叠区域，所以直接加入
        while (i < n && newInterval[0] > intervals[i][0]) {
            output.add(intervals[i]);
            i++;
        }
        if (output.isEmpty() || output.get(output.size() - 1)[1] < newInterval[0]) {
            // 没有重叠（空说明早于所有，最后一个的结束小于新的开始说明大于所有），直接加入
            output.add(newInterval);
        } else {
            // 有重叠，那么进行合并
            output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], newInterval[1]);
        }
        // 加入剩下的部分
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (output.get(output.size() - 1)[1] < start) {
                // 没有重叠，直接加入
                output.add(intervals[i]);
            } else {
                // 有重叠，进行合并
                output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], end);
            }
            i++;
        }
        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        int[][][] intervalsSet = new int[][][]{
                {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                {{1, 3}, {6, 9}},
        };
        int[][] newIntervalSet = new int[][]{
                {4, 8},
                {2, 5},
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < intervalsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = insertMy1(intervalsSet[i], newIntervalSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("insert My1 result" + i + " ");
            for (int[] list : result) {
                System.out.print("[");
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print("]; ");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < intervalsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = insertAnswer1(intervalsSet[i], newIntervalSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("insert Answer1 result" + i + " ");
            for (int[] list : result) {
                System.out.print("[");
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print("]; ");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
