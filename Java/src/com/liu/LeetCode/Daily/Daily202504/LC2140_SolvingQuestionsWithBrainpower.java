package com.liu.LeetCode.Daily.Daily202504;

public class LC2140_SolvingQuestionsWithBrainpower {
    // 一眼看过去，觉得应该用dp
    // Beats 96.96%
    private static long mostPointsMy1(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            int point = questions[i][0];
            int brainPower = questions[i][1];
            int nextQuestion = i + brainPower + 1;
            if (nextQuestion <= length) {
                dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);
            } else {
                dp[i] = Math.max(dp[i + 1], point + dp[length]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][][] questionsList = new int[][][]{
                {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}},
                {{3, 2}, {4, 3}, {4, 4}, {2, 5}},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < questionsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = mostPointsMy1(questionsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findAllRecipes My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
