package com.liu.LeetCode.FifteenPatterns.FastSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class LC202_HappyNumber {

    private static boolean isHappyMy1(int n) { // accepted 但是性能没那么好
        Set<Integer> cacheSet = new HashSet<>();
        int cache = n;
        while (!cacheSet.contains(cache)) {
            if (cache == 1) {
                return true;
            }
            cacheSet.add(cache);
            cache = happySquare(cache);
        }
        return false;
    }

    private static boolean isHappyAnswer1(int n) { // 使用slow、fast两个节点进行判断，性能会好一点
        int slow = n;
        int fast = happySquare(n);
        while (slow != fast) {
            slow = happySquare(slow);
            fast = happySquare(happySquare(fast));
        }
        return slow == 1;
    }

    private static int happySquare(int n) {
        int result = 0;
        String s = Integer.toString(n);
        for (char c : s.toCharArray()) {
            result += (c - '0') * (c - '0');
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ns = new int[]{
                1,
                19,
                2,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < ns.length; i++) {
            startTime = System.currentTimeMillis();
            result = isHappyMy1(ns[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isHappy My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < ns.length; i++) {
            startTime = System.currentTimeMillis();
            result = isHappyAnswer1(ns[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isHappy My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

}