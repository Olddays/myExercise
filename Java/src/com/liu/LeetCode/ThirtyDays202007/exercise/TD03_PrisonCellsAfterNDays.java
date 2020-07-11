package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liu on 2020/7/3.
 */
public class TD03_PrisonCellsAfterNDays {
    // Time Limited
    public static int[] prisonAfterNDaysMy1(int[] cells, int N) {
        int size = cells.length;
        int day = 0;
        while (day < N) {
            day++;
            int[] cache = new int[size];
            for (int i = 1; i < size - 1; i++) {
                if (cells[i + 1] == cells[i - 1]) {
                    cache[i] = 1;
                } else {
                    cache[i] = 0;
                }
            }
            cells = cache;
        }
        return cells;
    }

    public static int[] prisonAfterNDaysAnswer1(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;
        boolean hasCycle = false;
        int cycleTime = 0;
        Set<String> set = new HashSet<>();
        int index = 0;
        while (index < N) {
            index++;
            int[] next = nextDay(cells);
            if (!hasCycle) {
                String key = Arrays.toString(next);
                if (!set.contains(key)) {
                    set.add(key);
                    cycleTime++;
                } else {
                    hasCycle = true;
                    N = N % cycleTime;
                    index = 1;
                }
            }
            if (N != 0) {
                cells = next;
            }
        }
        return cells;
    }

    private static int[] nextDay(int[] cells) {
        int[] cache = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                cache[i] = 1;
            } else {
                cache[i] = 0;
            }
        }
        return cache;
    }
}
