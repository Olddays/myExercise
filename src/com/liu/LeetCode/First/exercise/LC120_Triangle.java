package com.liu.LeetCode.First.exercise;

import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC120_Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     * <p>
     * For example, given the following triangle
     * <p>
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * <p>
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * <p>
     * Note:
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */

    // 这一看就是个最优化算法,那么可以尝试通过dp来解决,寻找最优路径
    // 首先,由于是个正三角,下边比较大,所以从下到上的进行比较简单
    // 那么 我们假设寻找每一行最小值,然后再寻找能到达此值的值中的最小值,逐步遍历上去即可
    // 使用dp[]来暂存数据的话,最后dp[0]即是解,同时题目要求只能使用O(n)的额外空间(n为输入的行数)
    // 但是整体算法我们都在计算局部最优情况,可能会导致错过全局最优解
    public static int getTriangleMy1(List<List<Integer>> triangle) {
        int depth = triangle.size();
        if (depth == 0) {
            return 0;
        }
        List<Integer> lastLine = triangle.get(depth - 1);
        int maxWidth = lastLine.size();
        if (maxWidth == 0) {
            return 0;
        }
        int[] dp = new int[maxWidth];
        dp[maxWidth - 1] = lastLine.get(0);
        int local = 0;
        for (int i = 1; i < lastLine.size(); i++) {
            if (lastLine.get(i) < dp[maxWidth - 1]) {
                dp[maxWidth - 1] = lastLine.get(i);
                local = i;
            }
        }
        for (int i = depth - 2; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            // 我们并不知道0这个位置是否能到达
            // int cache = line.get(0);
            int cache = Integer.MAX_VALUE;
            int start = Math.max(local - 1, 0);
            // 从下到上的时候只能比较自己和自己前面一个值,不能比较更后面的值,因为是个三角形
            // int end = Math.min(local + 1, line.size() - 1);
            int end = Math.min(local, line.size() - 1);
            for (int j = start; j <= end; j++) {
                if (line.get(j) < cache) {
                    cache = line.get(j);
                    local = j;
                }
            }
            dp[i] = dp[i + 1] + cache;
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[0];
    }

    // https://discuss.leetcode.com/topic/1669/dp-solution-for-triangle
    public static int getTriangleAnswer1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
