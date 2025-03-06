package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2570_MergeTwo2DArraysBySummingValues {

    // Beats 100.00%
    private static int[][] mergeArraysMy1(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            int[] num1 = nums1[index1];
            int[] num2 = nums2[index2];
            if (num1[0] < num2[0]) {
                result.add(num1);
                index1++;
            } else if (num1[0] > num2[0]) {
                result.add(num2);
                index2++;
            } else {
                result.add(new int[]{num1[0], num1[1] + num2[1]});
                index1++;
                index2++;
            }
        }
        if (index1 < nums1.length) {
            for (int i = index1; i < nums1.length; i++) {
                result.add(nums1[i]);
            }
        }
        if (index2 < nums2.length) {
            for (int i = index2; i < nums2.length; i++) {
                result.add(nums2[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][][] nums1List = new int[][][]{
                {{1, 2}, {2, 3}, {4, 5}},
                {{2, 4}, {3, 6}, {5, 5}},
        };
        int[][][] nums2List = new int[][][]{
                {{1, 4}, {3, 2}, {4, 1}},
                {{1, 3}, {4, 3}},
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = mergeArraysMy1(nums1List[i], nums2List[i]);
            endTime = System.currentTimeMillis();
            System.out.print("mergeArrays My1 result" + i + " ");
            for (int[] vals : result) {
                for (int val : vals) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
