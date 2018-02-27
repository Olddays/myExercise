package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC229_MajorityElementII.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC229_MajorityElementIITest {

    public static void main(String[] args) {
        int[] nums = {
//                1
//                1, 2, 3
//                3, 2, 3
                1, 2
        };
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MajorityElementII My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("MajorityElementII Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1(int[] nums) {
        return getMajorityElementIIMy1(nums);
    }

    private static List<Integer> testAnswer1(int[] nums) {
        return getMajorityElementIIAnswer1(nums);
    }
}
