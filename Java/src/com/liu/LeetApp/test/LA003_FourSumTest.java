package com.liu.LeetApp.test;

import java.util.ArrayList;

import static com.liu.LeetApp.exercise.LA003_FourSum.*;

/**
 * Created by liu on 2016/11/28.
 */
public class LA003_FourSumTest {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 2, 1, -2, 1, -4, 5, 2, 3, 5, 2, 7, 9, -5, -7, -3, -4};
        int target = 3;
        ArrayList<ArrayList<Integer>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 1 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy2(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 2 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy3(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 3 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy4(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 4 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testMy5(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum my 5 during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }

        startTime = System.currentTimeMillis();
        result = testAnswer(input, target);
        endTime = System.currentTimeMillis();
        System.out.println("getThreeSum answer during time " + (endTime - startTime));
        for (ArrayList<Integer> item : result) {
            System.out.println("getThreeSum item");
            for (int i : item) {
                System.out.println("getThreeSum i " + i);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> testMy1(int[] input, int target) {
        return getFourSumMy1(input, target);
    }

    private static ArrayList<ArrayList<Integer>> testMy2(int[] input, int target) {
        return getFourSumMy2(input, target);
    }

    private static ArrayList<ArrayList<Integer>> testMy3(int[] input, int target) {
        return getFourSumMy3(input, target);
    }

    private static ArrayList<ArrayList<Integer>> testMy4(int[] input, int target) {
        return getFourSumMy4(input, target);
    }

    private static ArrayList<ArrayList<Integer>> testMy5(int[] input, int target) {
        return getFourSumMy5(input, target);
    }

    private static ArrayList<ArrayList<Integer>> testAnswer(int[] input, int target) {
        return getFourSumAnswer(input, target);
    }
}
