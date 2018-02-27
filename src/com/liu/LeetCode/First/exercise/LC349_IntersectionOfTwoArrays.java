package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC349_IntersectionOfTwoArrays {
    /**
     * Given two arrays, write a function to compute their intersection.
     * <p>
     * Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * <p>
     * Note:
     * Each element in the result must be unique.
     * The result can be in any order.
     */

    public static int[] getIntersectionOfTwoArraysMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] lengthTranscript = length1 > length2 ? nums1 : nums2;
        int[] shortTranscript = length1 < length2 ? nums1 : nums2;
        Set<Integer> set = new HashSet<>();
        for (int num : lengthTranscript) {
            set.add(num);
        }
        Set<Integer> cache = new HashSet<>();
        for (int num : shortTranscript) {
            if (set.contains(num)) {
                cache.add(num);
            }
        }
        int[] result = new int[cache.size()];
        Iterator<Integer> iterator = cache.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            result[i++] = num;
        }
        return result;
    }
}
