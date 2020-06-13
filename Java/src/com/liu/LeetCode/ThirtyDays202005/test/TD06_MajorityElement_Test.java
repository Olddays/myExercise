package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD06_MajorityElement.majorityElement;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD06_MajorityElement_Test {

    public static void main(String[] args) {
        int[] nums;
        int result;
        long startTime;
        long endTime;

        nums = new int[]{
                3, 2, 3
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_MajorityElement My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{
                2, 2, 1, 1, 1, 2, 2
        };
        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_MajorityElement My 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return majorityElement(nums);
    }

}
