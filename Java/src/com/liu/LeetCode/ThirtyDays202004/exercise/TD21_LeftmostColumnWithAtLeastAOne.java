package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.List;

/**
 * Created by Liu on 2020/4/22.
 */
public class TD21_LeftmostColumnWithAtLeastAOne {
    public interface BinaryMatrix {
        public int get(int x, int y);

        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> size = binaryMatrix.dimensions();
        int m = size.get(0);
        int n = size.get(1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            if (binaryMatrix.get(i, right) == 0) {
                continue;
            }
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (binaryMatrix.get(i, middle) == 1) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
                if (left < result && binaryMatrix.get(i, left) == 1) {
                    result = left;
                }
            }
        }
        if (result < Integer.MAX_VALUE) {
            return result;
        }
        return -1;
    }
}
