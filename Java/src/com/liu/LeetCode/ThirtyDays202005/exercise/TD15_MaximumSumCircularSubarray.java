package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/15.
 */
public class TD15_MaximumSumCircularSubarray {
    // Time Limited
    public static int maxSubarraySumCircularMy1(int[] A) {
        int length = A.length;
        int[] input = new int[length * 2];
        int[][] cache = new int[length][length];
        for (int i = 0; i < length; i++) {
            input[i] = A[i];
            input[length + i] = A[i];
        }
        cache[0][0] = A[0];
        int max = A[0];
        for (int i = 1; i < length; i++) {
            cache[i][0] = A[i];
            max = Math.max(max, cache[i][0]);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                cache[i][j % length] = cache[i][(j - 1) % length] + input[i + j];
                max = Math.max(max, cache[i][j % length]);
            }
        }
        return max;
    }

    public static int maxSubarraySumCircularMy2(int[] A) {
        int length = A.length;
        int max = 0;
        int cur = 0;
        int goThrough = 0;
        for (int i = 0; i < length * 2; i++) {
            if (goThrough == length) {
                 break;
            }
            cur = Math.max(0, cur + A[i % length]);
            max = Math.max(cur, max);
            if (cur == 0) {
                goThrough = 0;
            }
            goThrough += 1;
        }
        return max;
    }

    public static int maxSubarraySumCircularAnswer1(int[] A) {
        int length = A.length;

        int ans = A[0], cur = A[0];
        for (int i = 1; i < length; ++i) {
            cur = A[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[length];
        rightsums[length-1] = A[length-1];
        for (int i = length-2; i >= 0; --i)
            rightsums[i] = rightsums[i+1] + A[i];

        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxright = new int[length];
        maxright[length-1] = A[length-1];
        for (int i = length-2; i >= 0; --i)
            maxright[i] = Math.max(maxright[i+1], rightsums[i]);

        int leftsum = 0;
        for (int i = 0; i < length-2; ++i) {
            leftsum += A[i];
            ans = Math.max(ans, leftsum + maxright[i+2]);
        }

        return ans;
    }
}
