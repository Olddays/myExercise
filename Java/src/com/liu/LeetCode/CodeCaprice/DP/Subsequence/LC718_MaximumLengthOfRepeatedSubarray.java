package com.liu.LeetCode.CodeCaprice.DP.Subsequence;

public class LC718_MaximumLengthOfRepeatedSubarray {
    // Beats 19.75%
    private static int findLengthMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int max = 0;
        // dp[i][j] 表示nums1[i]与nums2[j]结尾的最长重复子数组长度
        int[][] dp = new int[length1][length2];
        // 初始化
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1;
                    max = 1; // 有可能只有这一个
                }
            }
        }
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 两个一起往前走，所以是i-1和j-1
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        // 不能返回dp[length1 - 1][length2 - 1]
        // 因为dp[i][j]表示的是nums1[i]与nums2[j]结尾的最长重复子数组长度
        // 而不是nums1[0:i]与nums2[0:j]的最长重复子数组长度
        // 所以需要遍历dp数组找到最大值
        return max;
    }

    // Beats 27.00%
    private static int findLengthMy2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int max = 0;
        // dp[i][j] 表示nums1[i]与nums2[j]结尾的最长重复子数组长度
        int[][] dp = new int[length1][length2];
        // 初始化
        for (int i = 0; i < length1; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                max = 1; // 有可能只有这一个
            }
        }
        for (int j = 0; j < length2; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
                max = 1; // 有可能只有这一个
            }
        }
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        // 不能返回dp[length1 - 1][length2 - 1]
        // 因为dp[i][j]表示的是nums1[i]与nums2[j]结尾的最长重复子数组长度
        // 而不是nums1[0:i]与nums2[0:j]的最长重复子数组长度
        // 所以需要遍历dp数组找到最大值
        return max;
    }

    // Beats 97.86%
    private static int findLengthAnswer1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp array to store lengths of common subarrays
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        // Loop through nums1 and nums2
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current elements match, extend the subarray length
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {1, 2, 3, 2, 8},
                {1, 2, 3, 2, 1},
                {0, 0, 0, 0, 0},
        };
        int[][] nums2Set = new int[][]{
                {5, 6, 1, 4, 7},
                {3, 2, 1, 4, 7},
                {0, 0, 0, 0, 0},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = findLengthMy1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findLength My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = findLengthMy2(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findLength My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = findLengthAnswer1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findLength Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
