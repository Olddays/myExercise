package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

public class LC1035_UncrossedLines {

    // 所谓的不相交，就是找最长相同子序列，顺序一样就不可能相交
    // Beats 97.21%
    private static int maxUncrossedLinesMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        // dp[i][j] 表示nums1[0:i]和nums2[0:j]的最大连线数量
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {2, 3, 1},
                {1, 3, 7, 1, 7, 5},
                {1, 4, 2},
                {2, 5, 1, 2, 5},
        };
        int[][] nums2Set = new int[][]{
                {3, 1, 3, 3, 3, 3},
                {1, 9, 2, 5, 1},
                {1, 2, 4},
                {10, 5, 2, 1, 5, 2},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxUncrossedLinesMy1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxUncrossedLines My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
