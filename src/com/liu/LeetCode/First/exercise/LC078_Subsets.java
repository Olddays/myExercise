package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC078_Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets.
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * For example,
     * If nums = [1,2,3], a solution is:
     * <p>
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */

    // 递归深度优先搜索
    public static List<List<Integer>> getSubsetsAnswer1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList)); // 每次添加的都是新构建出来的List
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            // 进入下一个之前把最后一个值去掉,这样按照输入[1,2,3]的情况,最后返回的数组为的写入顺序为:
            // 入口0加入[],入递归1加入[1],入递归2加入[1,2],入递归3加入[1,2,3],此时由于i==nums.length,出递归3,出递归2直接返回到tempList为[1,2]的时候,此时remove2,
            // 继续轮询到i==2,nums[i]==3,输入[1,3],此时由于i==nums.length,出递归1直接返回到tempList为[1]的时候,此时remove1,
            // 继续轮询到i==1,nums[i]==2,输入[2],继续入新递归1[2,3],此时由于i==nums.length,出新递归1直接返回到tempList为[2]的时候,此时remove2,
            // 继续轮询到i==3,nums[i]==3,输入[3],循环结束
            tempList.remove(tempList.size() - 1);
        }
    }
}
