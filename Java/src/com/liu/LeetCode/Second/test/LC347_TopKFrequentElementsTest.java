package com.liu.LeetCode.Second.test;

import java.util.List;

import static com.liu.LeetCode.Second.exercise.LC347_TopKFrequentElements.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC347_TopKFrequentElementsTest {

    public static void main(String[] args) {
        int[][] numSet = {
                {4, 1, -1, 2, -1, 2, 3},
                {2, 2, 1, 1, 1, 3},
        };
        int[] kSet = {
                2,
                2
        };
        long startTime;
        int[] result;
        long endTime;

        for (int i = 0; i < numSet.length; i++) {
            int[] nums = numSet[i];
            int k = kSet[i];

            startTime = System.currentTimeMillis();
            result = testMy1(nums, k);
            endTime = System.currentTimeMillis();
            System.out.println("TopKFrequentElements My 1 result.size() " + result.length + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();

            startTime = System.currentTimeMillis();
//            result = testAnswer1(nums, k);
            endTime = System.currentTimeMillis();
            System.out.println("TopKFrequentElements Answer 1 result.size() " + result.length + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[] testMy1(int[] nums, int k) {
        return topKFrequentMy1(nums, k);
    }

//    private static List<Integer> testAnswer1(int[] nums, int k) {
//        return getTopKFrequentElementsAnswer1(nums, k);
//    }
}
