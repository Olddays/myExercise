package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC093_RestoreIPAddresses {

    // Beats 99.02%
    private static List<String> restoreIpAddressesMy1(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }
        backtrackMy1(result, new StringBuilder(), s, 0, 4);
        return result;
    }

    private static void backtrackMy1(List<String> result, StringBuilder cache, String s, int start, int splitCount) {
        if (start == s.length() && splitCount == 0) {
            cache.deleteCharAt(cache.length() - 1);
            result.add(cache.toString());
            cache.append("."); // 这个很重要，如果不还原的话，会导致在delete并return后，下一次运行for循环里面的delete时越界error，因为删除内容少了个点
            return;
        }
        if (splitCount <= 0 || s.length() - start > 3 * splitCount || s.length() - start < splitCount) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String substr = s.substring(start, i + 1);
            if (isValidIP(substr)) {
                cache.append(substr).append(".");
                backtrackMy1(result, cache, s, i + 1, splitCount - 1);
                cache.delete(cache.length() - substr.length() - 1, cache.length());
            }
        }
    }

    private static boolean isValidIP(String substr) {
        if (substr.isEmpty() || substr.length() > 3) {
            return false;
        }
        if (substr.charAt(0) == '0' && substr.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(substr);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "0000",
                "25525511135",
                "101023",
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = restoreIpAddressesMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("restoreIpAddresses My1 result" + i + " ");
            for (String val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
