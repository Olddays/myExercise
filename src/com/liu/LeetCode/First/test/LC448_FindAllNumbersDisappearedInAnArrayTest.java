package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC448_FindAllNumbersDisappearedInAnArray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC448_FindAllNumbersDisappearedInAnArrayTest {

    public static void main(String[] args) {
        int[] nums = {
                4, 3, 2, 7, 8, 2, 3, 1
        };
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindAllNumbersDisappearedInAnArray Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testAnswer1(int[] nums) {
        return getFindAllNumbersDisappearedInAnArrayAnswer1(nums);
    }
}
