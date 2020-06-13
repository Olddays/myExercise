package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD01_FirstBadVersion.firstBadVersion;

/**
 * Created by Liu on 2020/5/6.
 */
public class TD01_FirstBadVersion_Test {

    public static void main(String[] args) {
        int[] nums = new int[]{2126753390};
        int result;
        long startTime;
        long endTime;

        for (int num : nums) {
            startTime = System.currentTimeMillis();
            result = testMy1(num);
            endTime = System.currentTimeMillis();
            System.out.println("TD01_FirstBadVersion My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int n) {
        return firstBadVersion(n);
    }

}
