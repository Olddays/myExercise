package com.liu.LeetCode.Daily.Daily202503;

public class LC1780_CheckIfNumberIsASumOfPowersOfThree {

    // 换句话说，其实是问能不能用类似是否选用3的n次方的和01串来表示n
    // 比如91=1+0+9+0+81，从3的0次方到3的4次方，也就是10101
    // 所以核心是，永远不会出现余数2，因为余数2意味着出现了某个3的N次方被用了两次
    private static boolean checkPowersOfThreeMy1(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                12,
                91,
                21,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = checkPowersOfThreeMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("checkPowersOfThree My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
