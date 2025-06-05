package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC3337_TotalCharactersInStringAfterTransformationsII {
    private static final int mod = 1000000007;

    // Beats 40.54%
    private static int lengthAfterTransformationsMy1(String s, int t, List<Integer> nums) {
        long[][] transform = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int shift = 0; shift < nums.get(i); shift++) {
                transform[i][(i + 1 + shift) % 26]++;
            }
        }
        transform = powerMatrix(transform, t);
        long[][] freq = new long[1][26];
        for (char ch : s.toCharArray()) {
            freq[0][ch - 'a']++;
        }
        freq = multiplyMatrices(freq, transform);
        long total = 0;
        for (long cnt : freq[0]) {
            total = (total + cnt) % mod;
        }
        return (int) total;
    }

    private static long[][] multiplyMatrices(long[][] A, long[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        long[][] result = new long[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                long sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum = (sum + (A[i][k] * B[k][j]) % mod) % mod;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    private static long[][] powerMatrix(long[][] matrix, long exponent) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) result = multiplyMatrices(result, matrix);
            matrix = multiplyMatrices(matrix, matrix);
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "abcyy",
                "azbk",
        };
        int[] tList = new int[]{
                2,
                1,
        };
        int[][] numsList = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        int[] resultList = new int[]{
                7,
                8,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = lengthAfterTransformationsMy1(sList[i], tList[i], nums);
            endTime = System.currentTimeMillis();
            System.out.println("lengthAfterTransformations My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
