package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

public class LC3355_ZeroArrayTransformationI {
    // Time Limit Exceeded
    // 应该用线段方式做
    private static boolean isZeroArrayMyError1(int[] nums, int[][] queries) {
        int length = nums.length;
        int[] cache = new int[length];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                cache[i]++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] - cache[i] > 0) {
                return false;
            }
        }
        return true;
    }

    // Beats 79.37%
    private static boolean isZeroArrayMy1(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] delta = new int[n + 1];

        // Apply range increments using difference array
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            delta[l]++;
            if (r + 1 < n) {
                delta[r + 1]--;
            }
        }

        // Build prefix sum array to get final increment count at each index
        int[] newDelta = new int[n];
        newDelta[0] = delta[0];
        for (int i = 1; i < n; i++) {
            newDelta[i] = newDelta[i - 1] + delta[i];
        }

        // Apply the reverse transformation
        for (int i = 0; i < n; i++) {
            int reduced = nums[i] - newDelta[i];
            if (reduced > 0) {
                return false;
            }
        }

        return true;
    }

    // 差分数列
    // 差分数列的主要适用场景是频繁对原始数组的某个区间的元素进行增减。
    // 差分数列的主要思想是，对于数组中的每个元素，我们用一个差分数组来记录它与前一个元素的差值。
    // 这样，我们就可以通过差分数组来快速地更新原始数组中的任意区间的元素。
    // 差分数列的主要优点是，它可以在 O(1) 的时间复杂度内更新原始数组中的任意区间的元素，而不需要遍历整个区间。
    // 差分数列的主要缺点是，它需要额外的空间来存储差分数组，因此在空间复杂度上可能会比原始数组稍高。
    // 差分数列的主要应用场景是，当我们需要频繁地对原始数组的某个区间的元素进行增减时，我们可以使用差分数列来优化时间复杂度。
    // diff记录变化量
    // 例如对于数组 [1, 2, 2, 3]，我们可以得到差分数组 [1, 0, 0, 1]，其中 diff[0] = 1，diff[1] = 0，diff[2] = 0，diff[3] = 1。
    // 这样，我们就可以通过 diff 数组来快速地更新原始数组中的任意区间的元素。
    // 例如，如果我们要将区间 [1, 3] 中的元素都加一，我们可以将 diff[1] 加一，diff[4] 减一，这样就可以在 O(1) 的时间复杂度内更新原始数组中的任意区间的元素。
    // 具体来说，我们可以将 diff[1] 加一，这样 diff[1] 就变成了 1，diff[2] 就变成了 1，diff[3] 就变成了 1，diff[4] 就变成了 0。
    // 这样，我们就可以通过 diff 数组来快速地更新原始数组中的任意区间的元素。
    // 核心是散列的记录变化，有一些类似dp，但是记录的不是dp结果，而是每一步的dp差
    private static boolean isZeroArrayAnswer1(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            // 区间 [l,r] 中的数都加一
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 此时 sumD 表示 nums[i] 要减掉多少
            if (nums[i] > sumD) { // nums[i] 无法变成 0
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {4, 3, 2, 1},
                {1, 0, 1},
        };
        int[][][] queriesList = new int[][][]{
                {{1, 3}, {0, 2}},
                {{0, 2}},
        };
        boolean[] resultList = new boolean[]{
                true,
                false,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = isZeroArrayMy1(numsList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isZeroArray My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
