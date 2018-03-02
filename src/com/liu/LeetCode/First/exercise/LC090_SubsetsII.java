package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC090_SubsetsII {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * For example,
     * If nums = [1,2,2], a solution is:
     * <p>
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     * <p>
     * nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     */

    public static List<List<Integer>> getSubsetsIIMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrace(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrace(List<List<Integer>> result, List<Integer> cache, int[] nums, int start) {
        result.add(new ArrayList<>(cache));
        int length = nums.length;
        for (int i = start; i < length; i++) {
            cache.add(nums[i]);
            if (cache.size() > 0 && result.contains(cache)) {
                // 先add上目前要加入的数字,再判断是否存在,如果已经存在,则删除当前数字并continue
                cache.remove(cache.size() - 1);
                continue;
            }
            backtrace(result, cache, nums, i + 1);
            cache.remove(cache.size() - 1);
        }
    }
}
