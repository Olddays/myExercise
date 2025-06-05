package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC3362_ZeroArrayTransformationIII {

    // 每次都找最左开头最大的右的区间，这也是一种贪心，因为找最大右端点，所以可以考虑最大堆
    // Beats 66.46%
    private static int maxRemovalMy1(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 维护左端点 <= i 的区间
            while (j < queries.length && queries[j][0] <= i) { // 在pq里面放入所有可以带来nums[i]减小的区间的右端点
                pq.add(queries[j][1]);
                j++;
            }
            // 选择右端点最大的区间
            while (sumD < nums[i] && !pq.isEmpty() && pq.peek() >= i) {// 计算最大能给nums[i]带来多少减小，并且右端点要>=i
                sumD++;
                diff[pq.poll() + 1]--; // 更新diff值，用于后续计算
            }
            if (sumD < nums[i]) {
                return -1;
            }
        }
        return pq.size(); // 剩下没用的，就是可以排除的区间对，也就是解
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {2, 0, 2},
                {1, 1, 1, 1},
                {1, 2, 3, 4},
        };
        int[][][] queriesList = new int[][][]{
                {{0, 2}, {0, 2}, {1, 1}},
                {{1, 3}, {0, 2}, {1, 3}, {1, 2}},
                {{0, 3}},
        };
        int[] resultList = new int[]{
                1,
                2,
                -1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxRemovalMy1(numsList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxRemoval My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}