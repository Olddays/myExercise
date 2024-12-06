package com.liu.LeetCode.CodeCaprice.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC494_4SumII {
    // 只考虑结果为0，不需要去重
    // 四数之和就需要考虑去重了
    // 性能一般，Beats 33.13%
    private static int fourSumCountMy1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 可以把四个数组，两两结合，变成两个大数组，此时时间复杂度是O(m*n+x*y)
        // 不仅要统计出现过，还得统计出现的次数
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int key = -num3 - num4;
                if (map.containsKey(key)) {
                    result += map.get(key);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {1, 2},
                {0},
        };
        int[][] nums2Set = new int[][]{
                {-2, -1},
                {0},
        };
        int[][] nums3Set = new int[][]{
                {-1, 2},
                {0},
        };
        int[][] nums4Set = new int[][]{
                {0, 2},
                {0},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = fourSumCountMy1(nums1Set[i], nums2Set[i], nums3Set[i], nums4Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("fourSumCount My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
