package com.liu.SelfTest.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.SelfTest.exercise.MT002_NumberDegree_GoogleInterview.*;

/**
 * Created by baidu on 2016/11/27.
 */
public class MT002_NumberDegree_GoogleInterviewTest {

    public static void main(String[] args) {

        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1, 2, 2, 3, 1});
        input.add(new int[]{1, 2, 2, 3, 1, 4, 2});
        int result;
        long startTime;
        long endTime;

        for (int[] nums : input) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("NumberDegree My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testAnswer1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("NumberDegree Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums) {
        return getNumberDegreeMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getNumberDegreeAnswer1(nums);
    }
}
