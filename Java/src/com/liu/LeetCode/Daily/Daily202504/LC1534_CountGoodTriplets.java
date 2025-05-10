package com.liu.LeetCode.Daily.Daily202504;

public class LC1534_CountGoodTriplets {

    // Beats 56.44%
    private static int countGoodTripletsMy1(int[] arr, int a, int b, int c) {
        int length = arr.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    // Beats 95.55%
    private static int countGoodTripletsMy2(int[] arr, int a, int b, int c) {
        int length = arr.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) { // 剪枝
                    for (int k = j + 1; k < length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {3, 0, 1, 1, 9, 7},
                {1, 1, 2, 2, 3},
        };
        int[] aList = new int[]{
                7,
                0,
        };
        int[] bList = new int[]{
                2,
                0,
        };
        int[] cList = new int[]{
                3,
                1,
        };
        int[] resultList = new int[]{
                4,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countGoodTripletsMy1(arrList[i], aList[i], bList[i], cList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countGoodTriplets My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countGoodTripletsMy2(arrList[i], aList[i], bList[i], cList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countGoodTriplets My2 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
