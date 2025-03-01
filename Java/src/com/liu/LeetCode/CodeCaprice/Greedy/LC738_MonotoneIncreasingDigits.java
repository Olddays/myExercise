package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC738_MonotoneIncreasingDigits {

    // Beats 80.91%
    private static int monotoneIncreasingDigitsMy1(int n) {
        String nStr = String.valueOf(n);
        int length = nStr.length();
        char[] nChars = nStr.toCharArray();
        for(int i = length - 1; i > 0; i--) { // 倒序遍历 核心是要明确得倒序
            if (nChars[i] < nChars[i - 1]) {
                nChars[i - 1]--; // 前一位减一，那么后面的就要改成9来确保最大
                for (int j = i; j < length; j++) {
                    nChars[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(nChars));
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                10,
                1234,
                332,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = monotoneIncreasingDigitsMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("monotoneIncreasingDigits My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
