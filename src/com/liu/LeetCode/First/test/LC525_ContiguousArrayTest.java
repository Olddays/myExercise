package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC525_ContiguousArray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC525_ContiguousArrayTest {

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{0, 1});
        input.add(new int[]{0, 1, 0});
        input.add(new int[]{0, 1, 0, 1});
        input.add(new int[]{0, 1, 1});
        input.add(new int[]{0, 1, 1, 0, 1, 0, 1});
        input.add(new int[]{0, 1, 0});
        input.add(new int[]{1, 1, 1, 1, 1});
        input.add(new int[]{1, 0, 1});
        input.add(new int[]{0, 0, 0, 1, 1, 1, 0});

        long startTime;
        int result;
        long endTime;

        for (int[] nums : input) {
            startTime = System.currentTimeMillis();
            result = testAnswer1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("ContiguousArray Answer 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer2(nums);
            endTime = System.currentTimeMillis();
            System.out.println("ContiguousArray Answer 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testAnswer1(int[] nums) {
        return getContiguousArrayAnswer1(nums);
    }

    private static int testAnswer2(int[] nums) {
        return getContiguousArrayAnswer2(nums);
    }
}
