package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC347_TopKFrequentElements {
    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     * <p>
     * For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
     * <p>
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public static List<Integer> getTopKFrequentElementsMy1(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0 || k <= 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        int minSize = Integer.MAX_VALUE;
        for (int num : nums) {
            int size = 1;
            if (map.containsKey(num)) {
                size += map.get(num);
            }
            map.put(num, size);
            maxSize = Math.max(maxSize, size);
            minSize = Math.min(minSize, size);
        }
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int size = entry.getValue();
            List<Integer> list;
            if (cache.containsKey(size)) {
                list = cache.get(size);
            } else {
                list = new ArrayList<>();
            }
            list.add(key);
            cache.put(size, list);
        }
        int size = 0;
        for (int i = maxSize; i >= minSize; i--) {
            if (cache.containsKey(i)) {
                List<Integer> list = cache.get(i);
                for (int num : list) {
                    if (size >= k) {
                        return result;
                    }
                    result.add(num);
                    size++;
                }
            }
        }
        return result;
    }

    /**
     * Idea is simple. Build a array of list to be buckets with length 1 to sort.
     */
    public static List<Integer> getTopKFrequentElementsAnswer1(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
