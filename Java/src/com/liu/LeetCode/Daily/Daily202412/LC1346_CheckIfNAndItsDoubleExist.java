package com.liu.LeetCode.Daily.Daily202412;

import java.util.Arrays;

public class LC1346_CheckIfNAndItsDoubleExist {

    private static boolean checkIfExistMy1(int[] arr) {
        int length = arr.length;
        int[] doubleArr = new int[length];
        for (int i = 0; i < length; i++) {
            doubleArr[i] = arr[i] * 2;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == doubleArr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {-2, 0, 10, -19, 4, 6, -8},
                {10, 2, 5, 3},
                {3, 1, 7, 11},
                {7, 1, 14, 11},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = checkIfExistMy1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("checkIfExist My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
