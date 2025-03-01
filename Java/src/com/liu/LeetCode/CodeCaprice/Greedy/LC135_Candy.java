package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC135_Candy {

    // Greedy Beats 83.55%
    // 考虑两侧的情况时，一定是先确定一边再确定另一边
    private static int candyMy1(int[] ratings) {
        int length = ratings.length;
        if (length <= 1) {
            return length;
        }
        int[] candies = new int[length];
        candies[0] = 1;
        for (int i = 1; i < length; i++) { // 从左到右
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) { // 从右到左
            if (ratings[i] > ratings[i + 1]) { // 必须是i和i+1比，因为最右边（边缘位置）的candy值已经确定
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] ratingsList = new int[][]{
                {1, 0, 2},
                {1, 2, 2},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < ratingsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = candyMy1(ratingsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("candy My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
