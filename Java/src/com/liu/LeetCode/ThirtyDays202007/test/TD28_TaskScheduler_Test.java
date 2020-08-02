package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD28_TaskScheduler.leastIntervalMy1;
import static com.liu.LeetCode.ThirtyDays202007.exercise.TD28_TaskScheduler.leastIntervalAnswer1;

/**
 * Created by Liu on 2020/7/28.
 */
public class TD28_TaskScheduler_Test {
    public static void main(String[] args) {
        char[] tasks;
        int n;
        int result;
        long startTime;
        long endTime;


        tasks = new char[]{
                'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I',
                'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R',
                'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        };
        n = 0;
        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler My 1 result: " + result + ", during time " + (endTime - startTime));


        tasks = new char[]{
                'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I',
                'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R',
                'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        };
        n = 2;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));

        tasks = new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        };
        n = 0;
        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_TaskScheduler Answer 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static int testMy1(char[] tasks, int n) {
        return leastIntervalMy1(tasks, n);
    }

    private static int testAnswer1(char[] tasks, int n) {
        return leastIntervalAnswer1(tasks, n);
    }
}
