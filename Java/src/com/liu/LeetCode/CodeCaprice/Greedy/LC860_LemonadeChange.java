package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC860_LemonadeChange {

    // Beats 94.00%
    private static boolean lemonadeChangeMy1(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else if (bill == 20) {
                twenty++;
                if (ten > 0) {
                    // 唯一需要贪心的地方，有10优先用10
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            // 不能让顾客等后面的钱，必须现场结清
            if (five < 0) {
                return false;
            }
        }
        return ten >= 0 && twenty >= 0;
    }

    public static void main(String[] args) {
        int[][] billsList = new int[][]{
                {5, 5, 5, 5, 20, 20, 5, 5, 5, 5},
                {5, 5, 5, 10, 20},
                {5, 5, 10, 10, 20},
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < billsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = lemonadeChangeMy1(billsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("lemonadeChange My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
