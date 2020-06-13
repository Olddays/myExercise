package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD12_SingleElementInASortedArray.singleNonDuplicateMy1;
import static com.liu.LeetCode.ThirtyDays202005.exercise.TD12_SingleElementInASortedArray.singleNonDuplicateMy2;

/**
 * Created by Liu on 2020/5/12.
 */
public class TD12_SingleElementInASortedArray_Test {
    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 1, 2, 3, 3, 4, 4, 8, 8},
                {3, 3, 7, 7, 10, 11, 11},
                {1, 1, 2},
                {1, 2, 2}
        };
        int result;
        long startTime;
        long endTime;

        for (int[] nums : numsSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD12_SingleElementInASortedArray My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(nums);
            endTime = System.currentTimeMillis();
            System.out.println("TD12_SingleElementInASortedArray My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums) {
        return singleNonDuplicateMy1(nums);
    }

    private static int testMy2(int[] nums) {
        return singleNonDuplicateMy2(nums);
    }
}
