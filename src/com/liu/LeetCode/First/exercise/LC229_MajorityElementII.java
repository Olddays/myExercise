package com.liu.LeetCode.First.exercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC229_MajorityElementII {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * The algorithm should run in linear time and in O(1) space.
     */

    public static List<Integer> getMajorityElementIIMy1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums); // 时间复杂度nlog(n)可能不符合题意,但是可以满足空间复杂度O(1),故先做出来
        int repeatSize = 0;
        int threshold = length / 3;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                repeatSize++;
            } else {
                if (repeatSize >= threshold) {
                    result.add(nums[i - 1]);
                }
                repeatSize = 0;
            }
        }
        if (repeatSize >= threshold) {
            result.add(nums[length - 1]);
        }
        return result;
    }

    // 这个解,有一个核心,就是如果在一个数组中有一些值能占比超过三分之一,那么这个值最多有两个,即:
    // 有a.length + b.length + ... = n 且 a.length > n/3 且 b.length > n/3 则有 a.length + b.length > 2n/3
    // 可得剩余部分占比一定小于 n/3
    // 但是显然方法不通用,当要求不是n/3的时候临时变量的数量又需要继续增加
    public static List<Integer> getMajorityElementIIAnswer1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int number1 = nums[0];
        int number2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        int len = nums.length;
        for (int num1 : nums) {
            if (num1 == number1) {
                count1++;
            } else if (num1 == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = num1;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num1;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;
    }
}
