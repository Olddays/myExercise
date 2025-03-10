package com.liu.LeetCode.Daily.Daily202503;

public class LC2379_MinimumRecolorsToGetKConsecutiveBlackBlocks {

    // error，这个for循环是给切割成n个k长度的段落，没有办法处理两个k长度段落内部的情况
    private static int minimumRecolorsMyError1(String blocks, int k) {
        int length = blocks.length();
        if (length < k) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - k + 1; i += k) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    count++;
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }

    // 滑动窗口
    // Beats 92.10%
    private static int minimumRecolorsMy1(String blocks, int k) {
        int length = blocks.length();
        if (length < k) {
            return 0;
        }
        int left = 0;
        int right = k;
        int count = 0;
        for (int i = left; i < right; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        int min = count;
        while (right < length) {
            // 窗口前移
            if (blocks.charAt(left) == 'W') {
                count--;
            }
            left++;
            right++;
            if (blocks.charAt(right - 1) == 'W') {
                count++;
            }
            min = Math.min(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
        String[] blocksList = new String[]{
                "WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW",
                "BWWWBB",
                "WBBWWBBWBW",
                "WBWBBBW",
        };
        int[] kList = new int[]{
                15,
                6,
                7,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < blocksList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minimumRecolorsMy1(blocksList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("closestPrimes My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
