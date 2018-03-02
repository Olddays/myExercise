package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC045_JumpGameII {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * For example:
     * Given array A = [2,3,1,1,4]
     * <p>
     * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     * <p>
     * Note:
     * You can assume that you can always reach the last index.
     */

    // 由于每一步表示最大的进度,所以应该可以考虑为一种广度优先搜索
    // 当只有一个输入的时候,需要走0步即可
    public static int getJumpGameIIMy1(int[] nums) {
        List<List<Integer>> cacheList = new ArrayList<>();
        backtrack(cacheList, new ArrayList<>(), nums, nums.length, 0);
        int result = Integer.MAX_VALUE;
        for (List<Integer> list : cacheList) {
            result = Math.min(result, list.size());
        }
        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        return result;
    }

    // 由于每一步表示最大的进度,所以应该可以考虑为一种广度优先搜索
    public static int getJumpGameIIMy2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        List<List<Integer>> cacheList = new ArrayList<>();
        backtrack(cacheList, new ArrayList<>(), nums, length, 0);
        int result = Integer.MAX_VALUE;
        for (List<Integer> list : cacheList) {
            result = Math.min(result, list.size());
        }
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain > 0) {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // 尝试加入下一个数字
                backtrack(list, tempList, nums, remain - nums[i], i + 1); // i + 1 because we can not reuse same elements
                tempList.remove(tempList.size() - 1); // 将尝试加入的数字删除进入下一个循环过程
            }
        } else {
            list.add(new ArrayList<>(tempList));
        }
    }

    // 其实就是从前往后走,每个点有多个选择,具体选择的个数取决于这个点上面值是多少
    public static int getJumpGameIIAnswer1(int[] nums) {
        int level = 0; // 跳转的次数
        int nowLength = 0; // 现在的位置
        int max = 0; // 最多能到哪个位置
        for (int i = 0; i < nums.length - 1; i++) { // 由于题目中提到,一定会走到最后,那么不需要遍历最后一个点
            max = Math.max(max, i + nums[i]); // i + nums[i]这个地方就是一定会正确的原因
            if (i == nowLength) {
                level++;
                nowLength = max;
            }
        }
        return level;
    }
}
