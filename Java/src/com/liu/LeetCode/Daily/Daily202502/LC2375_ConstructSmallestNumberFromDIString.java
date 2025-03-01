package com.liu.LeetCode.Daily.Daily202502;

public class LC2375_ConstructSmallestNumberFromDIString {

    // 反转法，根据题目的数学特性，当每遇到一个I或者在结束的时候，只要将之前的I到现在这个I之间的D的部分，进行反转即可
    // Beats 75.25%
    private static String smallestNumberAnswer1(String pattern) {
        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char) ('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                result.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] patternList = new String[]{
                "IIIDIDDD",
                "DDD",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < patternList.length; i++) {
            startTime = System.currentTimeMillis();
            result = smallestNumberAnswer1(patternList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("smallestNumber Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
