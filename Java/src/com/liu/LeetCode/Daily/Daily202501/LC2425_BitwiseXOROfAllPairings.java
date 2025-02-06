package com.liu.LeetCode.Daily.Daily202501;

public class LC2425_BitwiseXOROfAllPairings {
    // Time Limit Exceeded
    private static int xorAllNumsMy1(int[] nums1, int[] nums2) {
        int result = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                result ^= num1 ^ num2;
            }
        }
        return result;
    }

    private static int xorAllNumsAnswer1(int[] nums1, int[] nums2) {
        int num1 = 0;
        int num2 = 0;
        for (int a: nums1) {
            num1 ^= a;
        }
        for (int b: nums2) {
            num2 ^= b;
        }
        return (nums1.length % 2 * num2) ^ (nums2.length % 2 * num1);
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {2, 1, 3},
                {1, 2},
        };
        int[][] nums2Set = new int[][]{
                {10, 2, 5, 0},
                {3, 4},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = xorAllNumsMy1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("xorAllNums My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = xorAllNumsAnswer1(nums1Set[i], nums2Set[i]);
            endTime = System.currentTimeMillis();
            System.out.println("xorAllNums Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
