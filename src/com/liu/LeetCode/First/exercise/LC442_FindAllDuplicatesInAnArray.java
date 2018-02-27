package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC442_FindAllDuplicatesInAnArray {
    /**
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * <p>
     * Find all the elements that appear twice in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * <p>
     * Example:
     * <p>
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [2,3]
     */

    public static List<Integer> getFindAllDuplicatesInAnArrayMy1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length <= 1) {
            return result;
        }
        Arrays.sort(nums); // 快排,时间复杂度O(nlog(n))不是很满足题意,但是先这样做出来再说
        int cache = nums[0];
        boolean hasFound = false; // 用于规避一个值重复多次的情况
        for (int i = 1; i < length; i++) {
            if (nums[i] == cache) {
                if (!hasFound) {
                    result.add(nums[i]);
                }
                hasFound = true;
            } else {
                hasFound = false;
            }
            cache = nums[i];
        }
        return result;
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    // 操 太巧秒了...对于每一个值,题目有说明1 ≤ a[i] ≤ n (n = size of array),
    // 则证明不会数组越界,那么发现一个值就把他对应的位置的值改成负数,如果本身就是负数,说明已经有这个值了,
    public static List<Integer> getFindAllDuplicatesInAnArrayAnswer1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            // 原方案还有改进空间,针对[2, 2, 2, 2]这种情况会在返回值中出现两个2,
            // 虽然题目中已经提到了,some elements appear twice and others appear once最多出现两个一样的值
            nums[index] = -nums[index];
        }
        return result;
    }
}
