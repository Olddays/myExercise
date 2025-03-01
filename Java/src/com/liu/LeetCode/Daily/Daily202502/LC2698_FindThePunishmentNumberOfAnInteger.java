package com.liu.LeetCode.Daily.Daily202502;

public class LC2698_FindThePunishmentNumberOfAnInteger {

    private static int punishmentNumberAnswer1(int n) {
        int punishmentNum = 0;
        for (int curr = 1; curr <= n; curr++) {
            //finding square
            int square = curr * curr;
            if (canPartition(square, curr)) {
                punishmentNum += square;
            }
        }
        return punishmentNum;
    }

    private static boolean canPartition(int num, int target) {
        //invalid
        if (num < target || target < 0) {
            return false;
        }
        if (num == target) {
            return true;
        }
        // 尝试各种可能组合
        return (canPartition(num / 10, target - (num % 10))
                || canPartition(num / 100, target - (num % 100))
                || canPartition(num / 1000, target - (num % 1000)));
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                10,
                37,
                45,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = punishmentNumberAnswer1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("punishmentNumber Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
