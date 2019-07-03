package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC039_CombinationSum {
    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     * <p>
     * [
     * [7],
     * [2, 2, 3]
     * ]
     */

    // 缺少考虑数组为一个数字的情况,left应该从i开始来合并当:candidates.length == 1且target = n * candidates[0]
    public static List<List<Integer>> getCombinationSumMy1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            if (candidates[i] > target) {
                break;
            } else if (candidates[i] == target) {
                List<Integer> cache = new ArrayList<>();
                cache.add(candidates[i]);
                result.add(cache);
            }
            int size = 0;
            while (size * candidates[i] < target) {
                size++;
            }
            for (int j = 1; j <= size; j++) {
                int total = candidates[i] * j;
                int left = i + 1;
                List<Integer> leftCache = new ArrayList<>();
                while (left < length) {
                    total += candidates[left];
                    leftCache.add(candidates[left]);
                    if (total == target) {
                        List<Integer> cache = new ArrayList<>();
                        for (int k = 0; k < j; k++) {
                            cache.add(candidates[i]);
                        }
                        for (int index : leftCache) {
                            cache.add(index);
                        }
                        result.add(cache);
                        break;
                    } else if (total > target) {
                        break;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    // 由于total的相加,可能会加入无用元素,导致数据略过部分答案
    public static List<List<Integer>> getCombinationSumMy2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            if (candidates[i] > target) {
                break;
            } else if (candidates[i] == target) {
                List<Integer> cache = new ArrayList<>();
                cache.add(candidates[i]);
                result.add(cache);
            }
            int size = 0;
            while (size * candidates[i] < target) {
                size++;
            }
            for (int j = 1; j <= size; j++) {
                int total = candidates[i] * j;
                int left = i;
                List<Integer> leftCache = new ArrayList<>();
                while (left < length) {
                    total += candidates[left];
                    leftCache.add(candidates[left]);
                    if (total == target) {
                        List<Integer> cache = new ArrayList<>();
                        for (int k = 0; k < j; k++) {
                            cache.add(candidates[i]);
                        }
                        for (int index : leftCache) {
                            cache.add(index);
                        }
                        result.add(cache);
                        break;
                    } else if (total > target) {
                        break;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    // 需要考虑考虑数组为一个数字的情况,left应该从i开始来合并当:candidates.length == 1且target = n * candidates[0]
    // 缺少遍历,由于在j==1时,我们在while里预设了每次循环的时候都会加入下一个值,也就无法跳过某个值进行遍历
    public static List<List<Integer>> getCombinationSumMy3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        for (int i = 0; i < length; i++) {
            if (candidates[i] > target) {
                break;
            } else if (candidates[i] == target) {
                List<Integer> cache = new ArrayList<>();
                cache.add(candidates[i]);
                result.add(cache);
            }
            int size = 0;
            while (size * candidates[i] < target) {
                size++;
            }
            for (int j = 1; j <= size; j++) {
                int total = candidates[i] * j;
                int left = i + 1;
                List<Integer> leftCache = new ArrayList<>();
                while (left < length) {
                    if (total == target) {
                        List<Integer> cache = new ArrayList<>();
                        for (int k = 0; k < j; k++) {
                            cache.add(candidates[i]);
                        }
                        for (int index : leftCache) {
                            cache.add(index);
                        }
                        result.add(cache);
                        break;
                    }
                    total += candidates[left];
                    leftCache.add(candidates[left]);
                    if (total > target) {
                        break;
                    }
                    if (total < target) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    // 目前可以判断最后应该是一个深度优先的搜索,需要用到一个递归来进行处理
    public static List<List<Integer>> getCombinationSumAnswer1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain > 0) {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // 尝试加入下一个数字
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1); // 将尝试加入的数字删除进入下一个循环过程
            }
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            return;
        }
    }

}
