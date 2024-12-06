package com.liu.LeetCode.CodeCaprice.HashTable;

import java.util.*;

public class LC015_3Sum {
    // 用三个指针的方式进行，时间复杂度O(nlogn)
    // 难点在去重
    private static List<List<Integer>> threeSumMy1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            // 跳过重复的元素，但不跳过第0个位置，并且i跟i-1比较，是因为i-i已经用过了
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // 跳过重复的元素，j和j-1相比，是因为j已经前移了，j-1已经用过了
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    // 用HashMap方式进行，时间复杂度O(n^2)Time Limit Exceeded
    private static List<List<Integer>> threeSumMy2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                List<int[]> list = map.getOrDefault(sum, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(sum, list);
            }
        }
        for (int i = 0; i < length; i++) {
            int target = -nums[i];
            if (map.containsKey(target)) {
                List<int[]> list = map.get(target);
                for (int[] pair : list) {
                    if (pair[0] == i || pair[1] == i) continue;
                    List<Integer> cache = new ArrayList<>();
                    cache.add(nums[i]);
                    cache.add(nums[pair[0]]);
                    cache.add(nums[pair[1]]);
                    cache.sort(Comparator.comparingInt(o -> o));
                    if (result.contains(cache)) continue;
                    result.add(cache);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0},
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = threeSumMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("threeSum My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = threeSumMy2(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("threeSum My2 result" + i + " ");
            for (List<Integer> list : result) {
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
