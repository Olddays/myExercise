package com.liu.LeetCode.Daily.Daily202503;

public class LC2579_CountTotalNumberOfColoredCells {

    // Beats 13.52%
    private static long coloredCellsMy1(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result += (i - 1) * 4L;
        }
        return result;
    }

    // Beats 100.00%
    private static long coloredCellsMy2(int n) {
        return (long) n * (n - 1) * 2 + 1;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                1,
                2,
                3,
                4,
                5,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = coloredCellsMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("coloredCells My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = coloredCellsMy2(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("coloredCells My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
