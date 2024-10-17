package com.liu.LeetCode.Second.OverlappingIntervals;

import java.util.*;

public class LC056_MergeIntervals {

    private static int[][] mergeMy1(int[][] intervals) { // accepted 但性能相当差
        int length = intervals.length;
        if (length < 2) {
            return intervals;
        }
        List<int[]> cacheList = new ArrayList<>();
        Collections.addAll(cacheList, intervals);
        cacheList.sort(Comparator.comparingInt(o -> o[0]));
        int index = 1;
        while (index < cacheList.size()) {
            int[] lastInterval = cacheList.get(index - 1);
            int[] interval = cacheList.get(index);
            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                cacheList.remove(interval);
            } else {
                index++;
            }
        }
        return cacheList.toArray(new int[cacheList.size()][2]);
    }

    private static int[][] mergeAnswer1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] previous = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], interval[1]);
            } else {
                merged.add(previous);
                previous = interval;
            }
        }

        merged.add(previous);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][][] intervalsSet = new int[][][]{
                {{1, 3}, {2, 6}, {5, 10}, {8, 18}},
                {{1, 3}},
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}},
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < intervalsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = mergeMy1(intervalsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("merge My1 result" + i + " ");
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
            result = mergeAnswer1(intervalsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("merge Answer1 result" + i + " ");
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
