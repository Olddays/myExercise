package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC718_MaximumLengthOfRepeatedSubarray {
    /**
     * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * Output: 3
     * Explanation:
     * The repeated subarray with maximum length is [3, 2, 1].
     * <p>
     * Note:
     * <p>
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     */

    public static int getMaximumLengthOfRepeatedSubarrayAnswer1(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int result = 0;
        if (aLength == 0 || bLength == 0) {
            return result;
        }
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public static int getMaximumLengthOfRepeatedSubarrayAnswer2(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int result = 0;
        if (aLength == 0 || bLength == 0) {
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for (int i = 0; i < aLength; i++) {
            int n = A[i];
            list = map.getOrDefault(n, new ArrayList<>());
            list.add(i);
            map.put(n, list);
        }

        for (int i = 0; i < bLength && bLength - i > result; i++) {
            int n = B[i];
            if (map.containsKey(n)) {
                list = map.get(n);
                for (int m : list) {
                    if (aLength - m < result) {
                        break;
                    }
                    int count = 1, k = m + 1;
                    for (int j = i + 1; j < bLength && k < aLength; j++, k++) {
                        if (B[j] == A[k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
