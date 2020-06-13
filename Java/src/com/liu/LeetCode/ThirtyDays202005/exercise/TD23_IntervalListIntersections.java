package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/5/25.
 */
public class TD23_IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> cache = new ArrayList<>();
        int[][] result = new int[cache.size()][];
        int lengthA = A.length;
        int lengthB = B.length;
        int a = 0;
        int b = 0;
        while (a < lengthA && b < lengthB) {
            int start = Math.max(A[a][0], B[b][0]);
            int end = Math.min(A[a][1], B[b][1]);
            if (start <=  end) {
                cache.add(new int[]{start, end});
            }
            if (A[a][1] < B[b][1]) {
                a++;
            } else {
                b++;
            }
        }
        return cache.toArray(result);
    }
}
