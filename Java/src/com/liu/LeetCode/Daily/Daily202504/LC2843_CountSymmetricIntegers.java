package com.liu.LeetCode.Daily.Daily202504;

public class LC2843_CountSymmetricIntegers {

    // Beats 74.03%
    private static int countSymmetricIntegersMy1(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            if (length % 2 == 1) {
                continue;
            }
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < length / 2; j++) {
                leftSum += s.charAt(j) - '0';
                rightSum += s.charAt(length - 1 - j) - '0';
            }
            if (leftSum == rightSum) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] lowList = new int[]{
                1,
                1200,
        };
        int[] highList = new int[]{
                100,
                1230,
        };
        int[] resultList = new int[]{
                9,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < lowList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countSymmetricIntegersMy1(lowList[i], highList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countSymmetricIntegers My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
