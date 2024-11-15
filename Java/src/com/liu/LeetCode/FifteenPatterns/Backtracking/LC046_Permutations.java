package com.liu.LeetCode.FifteenPatterns.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking explores all possible solutions and backtracks when a solution path fails.
 * Use this pattern when you need to find all (or some) solutions to a problem that satisfies given constraints. For example: combinatorial problems, such as generating permutations, combinations, or subsets.
 * Sample Problem:
 * Generate all permutations of a given list of numbers.
 * Example:
 * Input: nums = [1, 2, 3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 * Explanation:
 * Use recursion to generate permutations.
 * For each element, include it in the current permutation and recursively generate the remaining permutations.
 * Backtrack when all permutations for a given path are generated.
 */
public class LC046_Permutations {
    private static List<List<Integer>> permuteMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        backtrackingMy1(result, list, nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrackingMy1(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtrackingMy1(result, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 2, 3},
                {0, 1},
                {1},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = permuteMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("permute My1 result" + i + " ");
            for (List<Integer> nums : result) {
                for (int num : nums) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
