package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC454_4SumII {
    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
     * <p>
     * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
     * <p>
     * Example:
     * <p>
     * Input:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * <p>
     * Output:
     * 2
     * <p>
     * Explanation:
     * The two tuples are:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */

    public static int get4SumIIAnswer1(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int a : A) {
            for (int b : B) {
                result += map.getOrDefault(-1 * (a + b), 0);
            }
        }
        return result;
    }
}
