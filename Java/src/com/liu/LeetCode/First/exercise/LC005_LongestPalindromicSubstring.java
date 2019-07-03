package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/8.
 */
public class LC005_LongestPalindromicSubstring {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Example:
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example:
     * Input: "cbbd"
     * Output: "bb"
     * <p>
     * palindromic表示"回文"
     * 把相同的词汇或句子，在下文中调换位置或颠倒过来，产生首尾回环的情趣，叫做回文，也叫回环。
     */

    public static String getLongestPalindromicSubstringMy1(String s) {
        if (null == s || s.equals("")) {
            return "";
        }
        char[] charSet = s.toCharArray();
        String newString = "@";
        for (char c : charSet) {
            newString += "#" + c;
        }
        newString += "#$";
        // 由于每个字符两边都加入了#,那么可以将中心为一个字符和两个字符的情况合并
        char[] newCharSet = newString.toCharArray();
        int[] palindromicLength = new int[newCharSet.length];
        int id = 0; // 用于标记最后一次排查过回文的位置
        int maxId = 0; // 用于标记最大位置,即最后一次排查过回文的位置加上其回文的长度的位置,由于每个字符两边都加了#,故回文至少长度为1
        int maxLength = 0;
        int maxCenterPostion = 0;
        for (int i = 1; i < newCharSet.length - 1; i++) {
            // 由于前后各加入了特殊字符,故遍历的时候左右各去除一个,而且借此来规避while寻找回文的时候的数组越界
            if (maxId > i) {
                // 对称点和距离值比较小的一方
                palindromicLength[i] = Math.min(maxId - i, palindromicLength[2 * id - i]);
            } else {
                palindromicLength[i] = 1;
            }
            // 用i为中心点寻找回文
            while (newCharSet[i - palindromicLength[i]] == newCharSet[i + palindromicLength[i]]) {
                palindromicLength[i]++;
            }
            if (palindromicLength[i] + i > maxId) {
                maxId = palindromicLength[i] + i;
                id = i;
            }
            if (maxLength < palindromicLength[i]) {
                maxLength = palindromicLength[i];
                maxCenterPostion = i;
            }
        }
        String result = newCharSet[maxCenterPostion] == '#' ? "" : String.valueOf(newCharSet[maxCenterPostion]);
        for (int i = 1; i < maxLength; i++) {
            char c = newCharSet[maxCenterPostion + i];
            if (c != '#') {
                result = c + result + c;
            }
        }
        // String.replaceAll()的方案会超时,时间复杂度高
        return result;
    }
}
