package com.liu.LeetCode.Daily.Daily202503;

import java.util.Arrays;

public class LC2594_MinimumTimeToRepairCars {

    // 假设一个时间t，在这个时间所有的车都能修好，所以可以通过二分搜索来找到最小的t
    // Beats 75.54%
    private static long repairCarsMy1(int[] ranks, int cars) {
        int length = ranks.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(ranks);
        long right = (long) ranks[0] * cars * cars; // 最快的独自干的时间，因为分开干肯定比最快的独自干的时间短
        long left = 1;
        while (left < right) { // 半开半闭区间
            long mid = (right + left) / 2;
            if (canRepair(ranks, cars, mid)) { // 能修完，说明时间给多了
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canRepair(int[] ranks, int cars, long mid) {
        long sum = 0;
        for (int rank : ranks) {
            sum += (int) Math.sqrt((double) mid / rank);
            if (sum >= cars) {
                return true;
            }
        }
        return sum >= cars;
    }

    public static void main(String[] args) {
        int[][] ranksSet = new int[][]{
                {4, 2, 3, 1},
                {5, 1, 8},
        };
        int[] carsSet = new int[]{
                10,
                6,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < ranksSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = repairCarsMy1(ranksSet[i], carsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("repairCars My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
