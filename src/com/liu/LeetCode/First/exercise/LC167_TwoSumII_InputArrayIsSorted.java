package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC167_TwoSumII_InputArrayIsSorted {
    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * <p>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p>
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * <p>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */

    public static int[] getTwoSumII_InputArrayIsSortedMy1(int[] numbers, int target) {
        int length = numbers.length;
        int[] result = new int[2];
        if (length == 0) {
            return result;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return result;
    }
}
