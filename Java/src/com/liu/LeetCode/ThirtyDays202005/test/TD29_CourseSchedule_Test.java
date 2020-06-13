package com.liu.LeetCode.ThirtyDays202005.test;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD29_CourseSchedule.canFinish;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD29_CourseSchedule_Test {
    public static void main(String[] args) {
        int numCourses;
        int[][] prerequisites;
        boolean result;
        long startTime;
        long endTime;

        numCourses = 3;
        prerequisites = new int[][]{
                {1, 0},
                {2, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_CourseSchedule My 1 result: " + result + ", during time " + (endTime - startTime));

        numCourses = 2;
        prerequisites = new int[][]{
                {1, 0}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_CourseSchedule My 1 result: " + result + ", during time " + (endTime - startTime));

        numCourses = 2;
        prerequisites = new int[][]{
                {1, 0},
                {0, 1}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_CourseSchedule My 1 result: " + result + ", during time " + (endTime - startTime));

        numCourses = 2;
        prerequisites = new int[][]{
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_CourseSchedule My 1 result: " + result + ", during time " + (endTime - startTime));

        numCourses = 5;
        prerequisites = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 2},
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD29_CourseSchedule My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static boolean testMy1(int numCourses, int[][] prerequisites) {
        return canFinish(numCourses, prerequisites);
    }
}
