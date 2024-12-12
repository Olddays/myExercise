package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.*;

public class LC347_TopKFrequentElements {
    // Map思路 Beats21.04%
    private static int[] topKFrequentMy1(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    // 大顶堆、小顶堆
    // 堆pop的时候，会把最上面的元素给pop掉，如果用大堆，那就会先删除最大的数
    // 所以要用小顶堆，这样才能保证最上面的元素是最小的数
    // Beats57.97%
    private static int[] topKFrequentMy2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result[i] = entry.getKey();
        }
        return result;
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

    }
}
