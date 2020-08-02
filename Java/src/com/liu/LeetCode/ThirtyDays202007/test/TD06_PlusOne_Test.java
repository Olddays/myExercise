package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD06_PlusOne.plusOne;

/**
 * Created by Liu on 2020/7/6.
 */
public class TD06_PlusOne_Test {

    public static void main(String[] args) {
        int[] cells;
        int[] result;
        long startTime;
        long endTime;


        cells = new int[]{
                1, 2, 3
        };
        startTime = System.currentTimeMillis();
        result = testMy1(cells);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_PlusOne My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        cells = new int[]{
                4, 3, 2, 1
        };
        startTime = System.currentTimeMillis();
        result = testMy1(cells);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_PlusOne My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        cells = new int[]{
                9
        };
        startTime = System.currentTimeMillis();
        result = testMy1(cells);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_PlusOne My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] cells) {
        return plusOne(cells);
    }

}
