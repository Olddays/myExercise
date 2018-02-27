package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC228_SummaryRanges.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC228_SummaryRangesTest {

    public static void main(String[] args) {
        int[] nums = {
//                0, 1, 2, 4, 5, 7
//                0, 2, 3, 4, 6, 8, 9
                -2147483648, -2147483647, 2147483647
        };
        long startTime;
        List<String> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SummaryRanges My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(nums);
        endTime = System.currentTimeMillis();
        System.out.println("SummaryRanges My 2 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static List<String> testMy1(int[] nums) {
        return getSummaryRangesMy1(nums);
    }

    private static List<String> testMy2(int[] nums) {
        return getSummaryRangesMy2(nums);
    }
}
