package com.liu.LeetCode.CodeCaprice.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC001_TwoSum {
    // 没问题，但是性能比较差，Beats 50.99%
    private static int[] twoSumMy1(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = target - entry.getKey();
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                result[0] = entry.getValue().get(0);
                if (entry.getValue() != list) {
                    result[1] = list.get(0);
                } else {
                    result[1] = list.get(1);
                }
                return result;
            }
        }
        return result;
    }

    // 没问题，但是性能依旧一般，Beats 64.80%
    private static int[] twoSumMy2(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]).get(0);
                result[1] = i;
                return result;
            }
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        return result;
    }

    // 没问题，去掉了List，w'w'w'w但是性能依旧一般，Beats 64.80%
    private static int[] twoSumMy3(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {3, 2, 4},
                {3, 3},
                {2, 7, 11, 15},
        };
        int[] targetSet = new int[]{
                6,
                6,
                9,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = twoSumMy1(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("twoSum My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = twoSumMy2(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("twoSum My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = twoSumMy3(numsSet[i], targetSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("twoSum My3 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
