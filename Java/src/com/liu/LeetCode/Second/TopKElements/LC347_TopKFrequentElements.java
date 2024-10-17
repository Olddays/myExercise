package com.liu.LeetCode.Second.TopKElements;

import java.util.*;

public class LC347_TopKFrequentElements {

    private static int[] topKFrequentMy1(int[] nums, int k) { // accepted 性能一般
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry);
            } else {
                heap.add(entry);
                heap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            if (!heap.isEmpty()) {
                result[i] = heap.poll().getKey();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private static int[] topKFrequentMy2(int[] nums, int k) { // accepted 性能比较差
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int index = 0;
        while (index < k) {
            Map.Entry<Integer, Integer> entry = list.get(list.size() - 1 - index);
            result[index] = entry.getKey();
            index++;
        }
        return result;
    }

    private static int[] topKFrequentAnswer1(int[] nums, int k) {
        // Find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        // Go through all numbers of the numFrequencyMap and push them into
        // topKElements, which will have
        // the top k frequent numbers. If the heap size is more than k, we remove the
        // smallest (top) number.
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) {
                topKElements.poll();
            }
        }

        // Create a list of top k numbers
        int[] topNumbers = new int[k];

        int i = 0;
        while (!topKElements.isEmpty()) {
            topNumbers[i] = topKElements.poll().getKey();
            i++;
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 1, 1, 2, 2, 3},
                {1},
        };
        int[] kSet = new int[]{
                2,
                1,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = topKFrequentMy1(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("topKFrequent My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = topKFrequentMy2(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("topKFrequent My2 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = topKFrequentAnswer1(numsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("topKFrequent Answer1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
