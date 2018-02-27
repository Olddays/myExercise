package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC041_FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * <p>
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * <p>
     * Your algorithm should run in O(n) time and uses constant space.
     */

    // 没有关注到输入为空时的状态
    public static int getFirstMissingPositiveMy1(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0 && nums[i - 1] > 0 && nums[i] - nums[i - 1] == 2) {
                return nums[i - 1] + 1;
            }
        }
        return nums[length - 1] + 1;
    }

    // 由于判断的是缺少的那个正整数,这里认为数组里面没有间隔为2的数字就返回最后一个值+1是不对的
    // 比如输入[2]时,应该返回1
    public static int getFirstMissingPositiveMy2(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > 0) {
                if (nums[i + 1] - nums[i] == 2) {
                    return nums[i] + 1;
                }
            }
        }
        if (length > 0) {
            return nums[length - 1] + 1;
        } else {
            return 1;
        }
    }

    // 没有考虑[1000, -1]这种情况
    public static int getFirstMissingPositiveMy3(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > 0) {
                if (nums[i + 1] - nums[i] == 2) {
                    return nums[i] + 1;
                }
            }
        }
        if (length > 0) {
            if (nums[0] > 1) {
                return nums[0] - 1;
            } else {
                return nums[length - 1] + 1;
            }
        } else {
            return 1;
        }
    }

    public static int getFirstMissingPositiveMy4(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums); // 先进行排序
        int firstPositiveIndex = -1; // 此处用于标记第一个非负数的序号
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        if (firstPositiveIndex > -1) {
            if (nums[firstPositiveIndex] > 1) { // 排序后数组的第一项如果大于1,那么直接返回1
                return 1;
            } else {
                for (int i = 0; i < length - 1; i++) { // i<length-1用于规避数组越界
                    if (nums[i] > 0) {
                        if (nums[i + 1] - nums[i] >= 2) { // 排序后数组的两项之间大小如果大于2,则直接返回两项中小的一个数字加1
                            return nums[i] + 1;
                        }
                    }
                }
                return nums[length - 1] + 1; // 如果在遍历过程中没有发现间距大于2的情况,那么直接返回最后一个值+1
            }
        } else { // 若序号为-1则说明nums的长度为0或nums里面全是负数,可以直接返回1
            return 1;
        }
    }
}
