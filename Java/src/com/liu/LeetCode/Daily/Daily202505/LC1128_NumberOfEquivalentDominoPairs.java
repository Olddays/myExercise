package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC1128_NumberOfEquivalentDominoPairs {
    // Beats 62.60%
    private static int numEquivDominoPairsMy1(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : dominoes) {
            if (pair[0] > pair[1]) {
                int cache = pair[1];
                pair[1] = pair[0];
                pair[0] = cache;
            }
            int cache = pair[0] * 10 + pair[1];
            map.put(cache,  map.getOrDefault(cache, 0) + 1);
        }
        int result = 0;
        for (int count : map.values()) {
            result += count * (count - 1) / 2;
        }
        return result;
    }

    // Beats 91.60%
    private static int numEquivDominoPairsAnswer1(int[][] dominoes) {
        int[] num = new int[100];
        int result = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            result += num[val];
            num[val]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] dominoesList = new int[][][]{
                {{1, 2}, {2, 1}, {3, 4}, {5, 6}},
                {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}},
        };
        int[] resultList = new int[]{
                1,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < dominoesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numEquivDominoPairsMy1(dominoesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numEquivDominoPairs My1 result" + i + " " + result + " result " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < dominoesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numEquivDominoPairsAnswer1(dominoesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numEquivDominoPairs Answer1 result" + i + " " + result + " result " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
