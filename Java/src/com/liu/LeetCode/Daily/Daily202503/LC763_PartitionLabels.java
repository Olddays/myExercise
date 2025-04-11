package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC763_PartitionLabels {
    // 滑动窗口
    // Beats 97.31%
    private static List<Integer> partitionLabelsMy1(String s) {
        List<Integer> result = new ArrayList<>();
        int length = s.length();
        // 记录每一个char的最后位置
        int[] charCount = new int[26]; // 26个小写字母
        for (int i = 0; i < length; i++) {
            charCount[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            right = Math.max(right, charCount[c - 'a']); // 找到最右边的位置
            if (i == right) { // 找到一个区间
                result.add(right - left + 1);
                left = right + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "ababcbacadefegdehijhklij",
                "eccbbbbdec",
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = partitionLabelsMy1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("partitionLabels My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
