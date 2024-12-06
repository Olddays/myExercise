package com.liu.LeetCode.CodeCaprice.HashTable;

import java.util.ArrayList;
import java.util.HashSet;

public class LC349_IntersectionOfTwoArrays {
    // 哈希操作还是挺慢的，还需要优化方法
    private static int[] intersectionMy1(int[] nums1, int[] nums2) {
        HashSet<Integer> cache = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                cache.add(num);
            }
        }
        return cache.stream().mapToInt(i -> i).toArray();
    }

    // 题目更新后，数字小于1000，可以用数组进行
    private static int[] intersectionMy2(int[] nums1, int[] nums2) {
        boolean[] set = new boolean[1001]; // 0-1000,共1001
        ArrayList<Integer> cache = new ArrayList<>();
        for (int num : nums1) {
            set[num] = true;
        }
        for (int num : nums2) {
            if (set[num]) {
                cache.add(num);
            }
            set[num] = false;
        }
        int[] result = new int[cache.size()];
        for (int i = 0; i < cache.size(); i++) {
            result[i] = cache.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] str1List = new int[][]{
                {1, 2, 2, 1},
                {4, 9, 5},
        };
        int[][] str2List = new int[][]{
                {2, 2},
                {9, 4, 9, 8, 4},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = intersectionMy1(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("intersection My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = intersectionMy2(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("intersection My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
