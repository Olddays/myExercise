package com.liu.LeetCode.First.exercise;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC228_SummaryRanges {
    /**
     * Given a sorted integer array without duplicates, return the summary of its ranges.
     * <p>
     * Example 1:
     * <p>
     * Input: [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * <p>
     * Example 2:
     * <p>
     * Input: [0,2,3,4,6,8,9]
     * Output: ["0","2->4","6","8->9"]
     */

    public static List<String> getSummaryRangesMy1(int[] nums) {
        List<String> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 1; i < length; i++) {
            int cache = nums[i] - nums[i - 1];
            // 没有考虑过在内存溢出情况下,如输入[-2147483647, 2147483647]时,cache会出现负值
            if (cache > 1) {
                if (start >= end) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            } else if (cache == 1) {
                end = i;
            }
        }
        if (start >= end) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[end]);
        }
        return result;
    }

    public static List<String> getSummaryRangesMy2(int[] nums) {
        List<String> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 1; i < length; i++) {
            int cache = nums[i] - nums[i - 1];
            if (cache > 1 || cache < 1) {
                if (start >= end) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            } else if (cache == 1) {
                end = i;
            }
        }
        if (start >= end) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[end]);
        }
        return result;
    }
}
