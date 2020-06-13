package com.liu.LeetCode.ThirtyDays202004.test;


import static com.liu.LeetCode.ThirtyDays202004.exercise.TD19_SearchInRotatedSortedArray.search;

public class TD19_SearchInRotatedSortedArray_Test {

    public static void main(String[] args) {
        int[] nums;
        int target;

        int result;
        long startTime;
        long endTime;

        nums = new int[]{
                4, 5, 6, 7, 0, 1, 2
        };
        target = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                4, 5, 6, 7, 0, 1, 2
        };
        target = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                1
        };
        target = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                1, 3
        };
        target = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                1, 3
        };
        target = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                3, 1
        };
        target = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                3, 1
        };
        target = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                3, 5, 1
        };
        target = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));

        nums = new int[]{
                4, 5, 6, 7, 8, 1, 2, 3
        };
        target = 8;
        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        System.out.println("TD17_NumberOfIslands My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums, int target) {
        return search(nums, target);
    }

}
