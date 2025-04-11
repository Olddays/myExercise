package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC3356_ZeroArrayTransformationII {

    // 先试试暴力
    // Time Limit Exceeded
    private static int minZeroArrayMyError1(int[] nums, int[][] queries) {
        int length = queries.length;
        int sum = Arrays.stream(nums).sum();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (sum == 0) {
                return count;
            }
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int value = query[2];
            for (int j = start; j <= end; j++) {
                if (nums[j] >= value) {
                    sum -= value;
                    nums[j] -= value;
                } else {
                    sum -= nums[j];
                    nums[j] = 0;
                }
            }
            count++;
        }
        if (sum == 0) {
            return count;
        }
        return -1;
    }

    // Beats 100.00%
    // line sweep
    // 这个思路是从左到右遍历数组，对于每个位置i，我们计算从0到i的元素和sum。
    // 如果sum小于nums[i]，说明需要增加元素，我们可以通过查询操作来增加元素。
    // 我们从左到右遍历查询数组queries，对于每个查询操作[l, r, val]，
    // 如果r < i，说明这个查询操作不会影响到位置i，我们可以跳过这个查询操作。
    // 否则，我们将val加到位置l和r+1处，这样就可以在区间[l, r]内增加元素。
    // 最后，我们再次遍历数组nums，计算从0到i的元素和sum，如果sum不等于nums[i]，说明无法将数组变成全0数组，返回-1。
    // 否则，返回查询操作的次数。
    // 这个算法的时间复杂度是O(n + m)，其中n是数组的长度，m是查询操作的次数。
    // 空间复杂度是O(n)，因为我们需要一个长度为n的数组来记录每个位置的元素和。
    private static int minZeroArrayAnswer1(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            while (sum + cnt[i] < nums[i]) {
                count++; // Increment count before accessing queries
                if (count - 1 >= queries.length) {
                    return -1;
                }
                int l = queries[count - 1][0];
                int r = queries[count - 1][1];
                int val = queries[count - 1][2];
                if (r < i) {
                    continue;
                }
                cnt[Math.max(l, i)] += val;
                cnt[r + 1] -= val;
            }
            sum += cnt[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2},
                {2, 0, 2},
                {4, 3, 2, 1},
        };
        int[][][] queriesList = new int[][][]{
                {{0, 0, 3}, {0, 0, 3}, {0, 0, 4}, {0, 0, 1}, {0, 0, 2}, {0, 0, 5}, {0, 0, 4}, {0, 0, 5}},
                {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}},
                {{1, 3, 2}, {0, 2, 1}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minZeroArrayAnswer1(numsList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minZeroArray Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
