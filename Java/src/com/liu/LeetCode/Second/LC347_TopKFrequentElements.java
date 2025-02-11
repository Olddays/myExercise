package com.liu.LeetCode.Second;

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

    public static void main(String[] args) {
        int[][] numSet = {
                {4, 1, -1, 2, -1, 2, 3},
                {2, 2, 1, 1, 1, 3},
        };
        int[] kSet = {
                2,
                2
        };
        long startTime;
        int[] result;
        long endTime;

        for (int i = 0; i < numSet.length; i++) {
            int[] nums = numSet[i];
            int k = kSet[i];

            startTime = System.currentTimeMillis();
            result = topKFrequentMy1(nums, k);
            endTime = System.currentTimeMillis();
            System.out.println("TopKFrequentElements My 1 result.size() " + result.length + " during time " + (endTime - startTime));
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
