package com.liu.LeetCode.ThirtyDays202005.exercise;

/**
 * Created by Liu on 2020/5/8.
 */
public class TD08_CheckIfItIsAStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        int pointSize = coordinates.length;
        if (pointSize <= 2) {
            return true;
        }
        int[] first = coordinates[0];
        int cache = 1;
        int[] second = coordinates[cache];
        while (first[0] == second[0] && first[1] == second[1]) {
            cache++;
            second = coordinates[cache];
        }
        if (first[0] == second[0]) {
            return false;
        }
        int a = (first[1] - second[1]) / (first[0] - second[0]);
        int b = (first[0] * second[1] - first[1] * second[0]) / (first[0] - second[0]);
        for (int i = 2; i < pointSize; i++) {
            int[] point = coordinates[i];
            if (a * point[0] + b != point[1]) {
                return false;
            }
        }
        return true;
    }
}
