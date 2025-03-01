package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.*;

public class LC763_PartitionLabels {

    // Beats 24.55%
    private static List<Integer> partitionLabelsMy1(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            right = Math.max(right, map.getOrDefault(c, 0));
            left = i;
            while (left < right) {
                char d = s.charAt(left);
                right = Math.max(right, map.getOrDefault(d, 0)); // 不断后移right
                left++;
            }
            result.add(right - i + 1);
            i = right;
        }
        return result;
    }

    // Beats 79.52%
    private static List<Integer> partitionLabelsAnswer1(String s) {
        List<Integer> result = new ArrayList<>();
        // 找到每个char的最后一个位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) { // 说明已经遍历到了当前区间的最后一个位置
                result.add(end - start + 1);
                start = i + 1; // Move to next partition
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

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = partitionLabelsAnswer1(sList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("partitionLabels Answer1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
