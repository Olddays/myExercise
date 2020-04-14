package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD07_CountingElements {
    public static int countElements(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return 0;
        }
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        max++;
        int[] cache = new int[max];
        for (int i : arr) {
            cache[i]++;
        }
        int result = 0;
        for (int i = 0; i < max - 1; i++) {
            if (cache[i] > 0 && cache[i + 1] > 0) {
                result += cache[i];
            }
        }
        return result;
    }
}
