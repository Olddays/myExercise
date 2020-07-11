package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.ArrayList;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD21_DungeonGame {

    // Memory Limited
    public static int calculateMinimumHPMy1(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        ArrayList<Integer> possibleDamage = new ArrayList<>();
        goThroughDungeon(possibleDamage, dungeon, m, n, 0, 0, 0, Integer.MAX_VALUE);
        int minDamage = possibleDamage.get(0);
        for (int damage : possibleDamage) {
            minDamage = Math.max(damage, minDamage);
        }
        if (minDamage > 0) {
            return 1;
        }
        return 1 - minDamage;
    }

    private static void goThroughDungeon(ArrayList<Integer> possibleDamage, int[][] dungeon, int m, int n, int i, int j,
                                         int damage, int maxDamage) {
        if (i < m && j < n) {
            int nowDamage = damage + dungeon[i][j];
            if (i == m - 1 && j == n - 1) {
                possibleDamage.add(Math.min(maxDamage, nowDamage));
            } else {
                // 右
                goThroughDungeon(possibleDamage, dungeon, m, n, i + 1, j, nowDamage, Math.min(maxDamage, nowDamage));
                // 下
                goThroughDungeon(possibleDamage, dungeon, m, n, i, j + 1, nowDamage, Math.min(maxDamage, nowDamage));
            }
        }
    }

    public static int calculateMinimumHPAnswer1(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            health[m - 1][i] = Math.max(health[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }
}
