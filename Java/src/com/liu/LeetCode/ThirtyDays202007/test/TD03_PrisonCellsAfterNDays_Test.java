package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD03_PrisonCellsAfterNDays.prisonAfterNDaysMy1;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD03_PrisonCellsAfterNDays.prisonAfterNDaysAnswer1;

/**
 * Created by Liu on 2020/7/3.
 */
public class TD03_PrisonCellsAfterNDays_Test {
    public static void main(String[] args) {
        int[] cells;
        int N;
        int[] result;
        long startTime;
        long endTime;


        cells = new int[]{
                0, 1, 0, 1, 1, 0, 0, 1
        };
        N = 7;
        startTime = System.currentTimeMillis();
        result = testMy1(cells, N);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_PrisonCellsAfterNDays My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        cells = new int[]{
                0, 0, 0, 1, 1, 0, 1, 0
        };
        N = 574;
        startTime = System.currentTimeMillis();
        result = testMy1(cells, N);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_PrisonCellsAfterNDays My 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();


        cells = new int[]{
                0, 1, 0, 1, 1, 0, 0, 1
        };
        N = 7;
        startTime = System.currentTimeMillis();
        result = testAnswer1(cells, N);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_PrisonCellsAfterNDays Answer 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        cells = new int[]{
                1, 0, 0, 1, 0, 0, 1, 0
        };
        N = 1000000000;
        startTime = System.currentTimeMillis();
        result = testAnswer1(cells, N);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_PrisonCellsAfterNDays Answer 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        cells = new int[]{
                0, 0, 0, 1, 1, 0, 1, 0
        };
        N = 574;
        startTime = System.currentTimeMillis();
        result = testAnswer1(cells, N);
        endTime = System.currentTimeMillis();
        System.out.println("TD03_PrisonCellsAfterNDays Answer 1 result.size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int[] cells, int N) {
        return prisonAfterNDaysMy1(cells, N);
    }

    private static int[] testAnswer1(int[] cells, int N) {
//        return
        return prisonAfterNDaysAnswer1(cells, N);
    }

}
