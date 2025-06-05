package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC1931_PaintingAGridWithThreeDifferentColors {

    // Beats 46.91%
    private static int colorTheGridAnswer1(int m, int n) {
        final int mod = 1_000_000_007;
        int total = 1;
        for (int i = 0; i < m; i++) {
            total *= 3;
        }
        int[][] dp = new int[n + 1][total];
        int[][] rowValid = new int[total][total];
        List<Integer> good = new ArrayList<>();
        List<Integer>[] pattern = new ArrayList[total];
        for (int i = 0; i < total; i++) {
            pattern[i] = new ArrayList<>();
        }
        for (int i = 0; i < total; i++) {
            int val = i, valid = 1;
            for (int j = 0; j < m; j++) {
                pattern[i].add(val % 3);
                val /= 3;
            }
            for (int j = 1; j < m; j++) {
                if (pattern[i].get(j).equals(pattern[i].get(j - 1))) {
                    valid = 0;
                    break;
                }
            }
            if (valid == 1) {
                good.add(i);
            }
        }
        for (int i : good) {
            dp[1][i] = 1;
        }
        for (int i : good) {
            for (int j : good) {
                rowValid[i][j] = 1;
                for (int k = 0; k < m; k++) {
                    if (pattern[i].get(k).equals(pattern[j].get(k))) {
                        rowValid[i][j] = 0;
                        break;
                    }
                }
            }
        }
        for (int col = 2; col <= n; col++) {
            for (int i : good) {
                long sum = 0;
                for (int j : good) {
                    if (rowValid[i][j] == 1) {
                        sum += dp[col - 1][j];
                    }
                }
                dp[col][i] = (int) (sum % mod);
            }
        }
        long ans = 0;
        for (int i = 0; i < total; i++) {
            ans += dp[n][i];
        }
        return (int) (ans % mod);
    }

    private static int colorTheGridAnswer2(int m, int n) {
        final int MOD = 1_000_000_007;
        int limit = 3 * (1 << (m - 1));
        int[][] mat = new int[limit][limit];
        for (int mask1 = 0; mask1 < limit; mask1++) {
            for (int mask2 = 0; mask2 < limit; mask2++) {
                int pos1 = mask1 >> (m - 1);
                int pos2 = mask2 >> (m - 1);
                boolean isValid = (pos1 != pos2);
                for (int j = 0; j < m - 1 && isValid; j++) {
                    int d1 = 2 * (mask1 >> (m - 2 - j)) - 1;
                    int d2 = 2 * (mask2 >> (m - 2 - j)) - 1;
                    pos1 = (pos1 + 3 + d1) % 3;
                    pos2 = (pos2 + 3 + d2) % 3;
                    isValid = (pos1 != pos2);
                }
                mat[mask1][mask2] = isValid ? 1 : 0;
            }
        }
        int[][] state = new int[limit][1];
        for (int i = 0; i < limit; i++) {
            state[i][0] = 1;
        }
        for (n--; n > 0; n /= 2) {
            if (n % 2 == 1) {
                state = multi(mat, state);
            }
            mat = multi(mat, mat);
        }
        int ret = 0;
        for (int i = 0; i < limit; i++) {
            ret = (ret + state[i][0]) % MOD;
        }
        return ret;
    }

    private static int[][] multi(int[][] A, int[][] B) {
        final int MOD = 1_000_000_007;
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] = (int) ((result[i][j] + (((long) A[i][k]) * B[k][j])) % MOD);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] mList = new int[]{
                1,
                1,
                5,
        };
        int[] nList = new int[]{
                1,
                2,
                5,
        };
        int[] resultList = new int[]{
                3,
                6,
                580986
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < mList.length; i++) {
            startTime = System.currentTimeMillis();
            result = colorTheGridAnswer1(mList[i], nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("colorTheGrid Answer1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < mList.length; i++) {
            startTime = System.currentTimeMillis();
            result = colorTheGridAnswer2(mList[i], nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("colorTheGrid Answer2 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
