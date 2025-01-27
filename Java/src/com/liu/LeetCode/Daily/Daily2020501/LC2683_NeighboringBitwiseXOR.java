package com.liu.LeetCode.Daily.Daily2020501;

import java.util.Arrays;

public class LC2683_NeighboringBitwiseXOR {

    // Beats 10%
    private static boolean doesValidArrayExistAnswer1(int[] derived) {
        return Arrays.stream(derived).sum() % 2 == 0;
    }

    // Beats 100%
    private static boolean doesValidArrayExistAnswer2(int[] derived) {
        int xr = 0;
        for (int x : derived) {
            xr = xr ^ x;
        }
        return xr == 0;
    }

    public static void main(String[] args) {
        int[][] derivedSet = new int[][]{
                {1, 1, 0},
                {1, 1},
                {1, 0},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < derivedSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = doesValidArrayExistAnswer1(derivedSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("doesValidArrayExist My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < derivedSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = doesValidArrayExistAnswer2(derivedSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("doesValidArrayExist My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
