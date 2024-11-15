package com.liu.LeetCode.Second.exercise;

import java.util.*;

public class LC347_TopKFrequentElements {

    public static int[] topKFrequentMy1(int[] nums, int k) {
        int length = nums.length;
        List<Integer>[] bucket = new List[length + 1];
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

        int[] result = new int[k];
        int index = 0;
        for (int pos = bucket.length - 1; pos >= 0 && index < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]){
                    result[index++] = num;
                    if (index >= k) {
                        break;
                    }
                }
            }
        }
        return result;
    }

}
