package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC621_TaskScheduler.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC621_TaskSchedulerTest {

    public static void main(String[] args) {
        char[] tasks = {
//                'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'
//                'A', 'A', 'A', 'B', 'B', 'B'
                'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'
        };
        int n = 2;
//        int n = 50;
        long startTime;
        int result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TaskScheduler My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testMy2(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TaskScheduler My 2 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1(tasks, n);
        endTime = System.currentTimeMillis();
        System.out.println("TaskScheduler Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(char[] tasks, int n) {
        return getTaskSchedulerMy1(tasks, n);
    }

    private static int testMy2(char[] tasks, int n) {
        return getTaskSchedulerMy2(tasks, n);
    }

    private static int testAnswer1(char[] tasks, int n) {
        return getTaskSchedulerAnswer1(tasks, n);
    }
}
