package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.*;

public class LC131_PalindromePartitioning {

    // Beats 97.02%
    private static List<List<String>> partitionMy1(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrackMy1(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrackMy1(List<List<String>> result, ArrayList<String> cache, String s, int index) {
        if (index == s.length()) {
            if (!cache.isEmpty()) {
                result.add(new ArrayList<>(cache));
            }
            return; // return逻辑，应该是判断当前的切分方法已经完成
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {// 回文串判断
                cache.add(s.substring(index, i + 1));
                backtrackMy1(result, cache, s, i + 1);
                cache.remove(cache.size() - 1);
            }
            // 当当前index到i不是回文的时候，就会i++查看下一个是不是回文，直到i越界，然后回退到上一层
        }
    }

    // 判断s从indexStart开始到indexEnd的字符串是不是回文
    // 注意indexEnd的边界，不要越界，也不要少遍历
    private static boolean isPalindrome(String s, int indexStart, int indexEnd) {
        while (indexStart < indexEnd) {
            if (s.charAt(indexStart) != s.charAt(indexEnd)) {
                return false;
            }
            indexStart++;
            indexEnd--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "aab",
                "a",
        };
        List<List<String>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = partitionMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("partition My1 result" + i + " ");
            for (List<String> list : result) {
                for (String val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
