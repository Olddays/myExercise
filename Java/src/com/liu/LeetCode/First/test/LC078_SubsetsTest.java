package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC078_Subsets.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC078_SubsetsTest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("Subsets Answer 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testAnswer1(int[] nums) {
        return getSubsetsAnswer1(nums);
    }
}
