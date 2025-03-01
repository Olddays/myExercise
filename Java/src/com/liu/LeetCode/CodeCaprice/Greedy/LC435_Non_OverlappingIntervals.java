package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC435_Non_OverlappingIntervals {

    // Beats 12.90%
    private static int eraseOverlapIntervalsMy1(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) { // 开头一样的话，结尾大的排在前面
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0]; // 开头不一样的话，开头小的排在前面
        }); // 贪心：此时如果两个段落重叠，那么删除结尾大的段落
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] < end) { // 重叠
                count++;
                end = Math.min(end, intervals[i][1]); // 删掉大的，等于剩下了小的，那就选择结束位置更小的继续遍历
            } else {
                end = intervals[i][1]; // 没重叠，那就往后移动
            }
        }
        return count;
    }

    private static int eraseOverlapIntervalsMy2(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); // 贪心：此时如果两个段落重叠，那么删除结尾大的段落
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] < end) { // 重叠
                count++;
                end = Math.min(end, intervals[i][1]); // 删掉大的，等于剩下了小的，那就选择结束位置更小的继续遍历
            } else {
                end = intervals[i][1]; // 没重叠，那就往后移动
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][][] intervalsList = new int[][][]{
                {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}},
                {{1, 2}, {2, 3}, {3, 4}, {1, 3}},
                {{1, 2}, {1, 2}, {1, 2}},
                {{1, 2}, {2, 3}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < intervalsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = eraseOverlapIntervalsMy1(intervalsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("eraseOverlapIntervals My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < intervalsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = eraseOverlapIntervalsMy2(intervalsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("eraseOverlapIntervals My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
