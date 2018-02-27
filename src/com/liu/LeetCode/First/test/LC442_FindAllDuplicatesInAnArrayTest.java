package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC442_FindAllDuplicatesInAnArray.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC442_FindAllDuplicatesInAnArrayTest {

    public static void main(String[] args) {
        int[] nums = {
                4, 3, 2, 7, 8, 2, 3, 1, 2, 2
        };
        long startTime;
        List<Integer> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindAllDuplicatesInAnArray My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[]{
                4, 3, 2, 7, 8, 2, 3, 1, 2, 2
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("FindAllDuplicatesInAnArray Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1(int[] nums) {
        return getFindAllDuplicatesInAnArrayMy1(nums);
    }

    private static List<Integer> testAnswer1(int[] nums) {
        return getFindAllDuplicatesInAnArrayAnswer1(nums);
    }
}
