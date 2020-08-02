package com.liu.LeetCode.ThirtyDays202007.test;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD18_CourseScheduleII.findOrderAnswer1;

/**
 * Created by Liu on 2020/7/20.
 */
public class TD18_CourseScheduleII_Test {

    public static void main(String[] args) {
        int numCourses;
        int[][] prerequisites;
        int[] result;
        long startTime;
        long endTime;


        numCourses = 2;
        prerequisites = new int[][]{
                {1, 0}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_CourseScheduleII My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        numCourses = 4;
        prerequisites = new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(numCourses, prerequisites);
        endTime = System.currentTimeMillis();
        System.out.println("TD18_CourseScheduleII My 1 result size: " + result.length + ", during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] testMy1(int numCourses, int[][] prerequisites) {
        return findOrderAnswer1(numCourses, prerequisites);
    }

}
