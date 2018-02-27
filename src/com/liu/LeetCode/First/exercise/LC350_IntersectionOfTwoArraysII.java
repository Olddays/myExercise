package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC350_IntersectionOfTwoArraysII {
    /**
     * Given two arrays, write a function to compute their intersection.
     * <p>
     * Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     * <p>
     * Note:
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */

    public static int[] getIntersectionOfTwoArraysIIMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] lengthTranscript = length1 >= length2 ? nums1 : nums2;
        int[] shortTranscript = length1 < length2 ? nums1 : nums2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : lengthTranscript) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : shortTranscript) {
            if (map.containsKey(num)) {
                int size = map.get(num);
                if (size > 0) {
                    list.add(num);
                    size--;
                    map.put(num, size);
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * 针对更深入方向的问题(即内存不足情况下)
     * Solution to 3rd follow-up question
     * What if elements of nums2 are stored on disk, and the memory is
     * limited such that you cannot load all elements into the memory at
     * once?
     * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
     * <p>
     * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
     */
}
