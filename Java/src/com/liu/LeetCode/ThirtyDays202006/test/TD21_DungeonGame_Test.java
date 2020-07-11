package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD21_DungeonGame.calculateMinimumHPMy1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD21_DungeonGame.calculateMinimumHPAnswer1;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD21_DungeonGame_Test {
    public static void main(String[] args) {
        int[][] dungeon;
        int result;
        long startTime;
        long endTime;


        dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        startTime = System.currentTimeMillis();
        result = testMy1(dungeon);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_LongestDuplicateSubstring My 1 result: " + result + ", during time " + (endTime - startTime));


        dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        startTime = System.currentTimeMillis();
        result = testAnswer1(dungeon);
        endTime = System.currentTimeMillis();
        System.out.println("TD19_LongestDuplicateSubstring Answer 1 result: " + result + ", during time " + (endTime - startTime));

    }

    private static int testMy1(int[][] dungeon) {
        return calculateMinimumHPMy1(dungeon);
    }

    private static int testAnswer1(int[][] dungeon) {
        return calculateMinimumHPAnswer1(dungeon);
    }

}
