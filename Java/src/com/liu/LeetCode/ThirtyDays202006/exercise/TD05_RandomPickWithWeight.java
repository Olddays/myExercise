package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.Random;

/**
 * Created by Liu on 2020/6/5.
 */
public class TD05_RandomPickWithWeight {

    public static class Solution {
        private int length;
        private int sum;
        private int[] indexSet;
        private Random random;

        public Solution(int[] w) {
            length = w.length;
            sum = 0;
            indexSet = new int[length];
            random = new Random();
            for (int i = 0; i < length; i++) {
                sum += w[i];
                indexSet[i] = sum;
            }
        }

        public int pickIndex() {
            int num = random.nextInt(sum) + 1;
            int left = 0, right = length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (indexSet[mid] == num) {
                    return mid;
                } else if (indexSet[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
