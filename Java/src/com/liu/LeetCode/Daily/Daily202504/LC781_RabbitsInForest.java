package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC781_RabbitsInForest {

    // Beats 30.84%
    private static int numRabbitsMy1(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += Math.ceil(((double) entry.getValue() / (entry.getKey() + 1))) * (entry.getKey() + 1);
        }
        return result;
    }

    // Beats 100.00%
    private static int numRabbitsAnswer1(int[] answers) {
        int[] count = new int[1000];

        int ans = 0;
        for (int x : answers) { // x+1 x+1抵消
            if (++count[x] == 1) {
                ans += x + 1;
            }
            if (count[x] == x + 1) { // 满了x+1就抵消掉，继续往后
                count[x] = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] answersList = new int[][]{
                {0, 0, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 2},
                {10, 10, 10},
        };
        int[] resultList = new int[]{
                6,
                5,
                5,
                11,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < answersList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numRabbitsMy1(answersList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numRabbits My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < answersList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numRabbitsAnswer1(answersList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numRabbits Answer1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
