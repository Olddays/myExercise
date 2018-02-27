package com.liu.LeetApp.test;


import java.util.ArrayList;

import static com.liu.LeetApp.exercise.LA002_ThreeSum.*;

/**
 * Created by baidu on 2016/11/27.
 */
public class LA002_ThreeSumTest {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 2, 1, -2, 1, -4};
        ArrayList<ArrayList<Integer>> result;
        long startTime;
        long endTime;

        // 方案一是死循环,不进行测试

        startTime = System.currentTimeMillis();
        result = testMy2(input);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 2 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy3(input);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 3 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum answer during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> testMy1(int[] input) {
        return getThreeSumMy1(input);
    }

    private static ArrayList<ArrayList<Integer>> testMy2(int[] input) {
        return getThreeSumMy2(input);
    }

    private static ArrayList<ArrayList<Integer>> testMy3(int[] input) {
        return getThreeSumMy3(input);
    }

    private static ArrayList<ArrayList<Integer>> testAnswer(int[] input) {
        return getThreeSumAnswer(input);
    }
}
