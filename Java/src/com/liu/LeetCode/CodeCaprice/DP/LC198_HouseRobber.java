package com.liu.LeetCode.CodeCaprice.DP;

public class LC198_HouseRobber {

    private static int robMy1(int[] nums) {

    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = robMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("rob My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
