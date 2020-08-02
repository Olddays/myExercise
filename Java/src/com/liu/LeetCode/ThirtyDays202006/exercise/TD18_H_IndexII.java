package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/18.
 */
public class TD18_H_IndexII {
    public static int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (citations[mid] < length - mid) {
                left = mid + 1;
            } else if (citations[mid] > length - mid) {
                right = mid - 1;
            } else {
                return citations[mid];
            }
        }
        return length - right - 1;
    }
}
