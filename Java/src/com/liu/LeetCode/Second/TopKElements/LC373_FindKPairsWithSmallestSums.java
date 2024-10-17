package com.liu.LeetCode.Second.TopKElements;

import java.util.*;

public class LC373_FindKPairsWithSmallestSums {

    // Time Limit Exceeded 性能太差
    private static List<List<Integer>> kSmallestPairsMy1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> cache = new ArrayList<>();
                cache.add(i);
                cache.add(j);
                map.put(cache, nums1[i] + nums2[j]);
            }
        }
        PriorityQueue<Map.Entry<List<Integer>, Integer>> heap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry);
            } else {
                heap.add(entry);
                Map.Entry<List<Integer>, Integer> entry2 = heap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            List<Integer> point = heap.poll().getKey();
            List<Integer> cache = new ArrayList<>();
            cache.add(nums1[point.get(0)]);
            cache.add(nums2[point.get(1)]);
            result.add(cache);
        }
        return result;
    }

    // Time Limit Exceeded 性能太差 虽然减少了Map和一个for
    private static List<List<Integer>> kSmallestPairsMy2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Map.Entry<List<Integer>, Integer>> heap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> cache = new ArrayList<>();
                cache.add(i);
                cache.add(j);
                Map.Entry<List<Integer>, Integer> entry = new HashMap.SimpleEntry<>(cache, nums1[i] + nums2[j]);
                if (heap.size() < k) {
                    heap.add(entry);
                } else {
                    heap.add(entry);
                    heap.poll();
                }
            }
        }
        for (int i = 0; i < k; i++) {
            List<Integer> point = heap.poll().getKey();
            List<Integer> cache = new ArrayList<>();
            cache.add(nums1[point.get(0)]);
            cache.add(nums2[point.get(1)]);
            result.add(cache);
        }
        return result;
    }

    // 核心是因为只要最小的，所以先把nums1的全部和nums2[0]做匹配，然后再逐步看看行不行，至少nums1[0],nums2[0]是肯定符合要求的
    // 性能一般
    private static List<List<Integer>> kSmallestPairsAnswer1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 这里为什么用大堆？
        // 因为大堆取出来的第一个，就是最小的，小堆反而要排除所有大的才行，这个题因为特性，不需要全丢进去，全丢进去时间太久，只要找到前K个就够了
        PriorityQueue<Map.Entry<List<Integer>, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.add(new HashMap.SimpleEntry<>(Arrays.asList(i, 0), nums1[i] + nums2[0]));
        }
        int count = 0;
        while (!heap.isEmpty() && count < k) {
            Map.Entry<List<Integer>, Integer> entry = heap.poll();
            int index1 = entry.getKey().get(0);
            int index2 = entry.getKey().get(1);
            result.add(Arrays.asList(nums1[index1], nums2[index2]));
            int nextIndex2 = index2 + 1;
            if (nextIndex2 < nums2.length) {
                heap.add(new HashMap.SimpleEntry<>(Arrays.asList(index1, nextIndex2), nums1[index1] + nums2[nextIndex2]));
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums1Set = new int[][]{
                {1, 2, 4, 5, 6},
                {1, 1, 2},
                {1, 7, 11},
        };
        int[][] nums2Set = new int[][]{
                {3, 5, 7, 9},
                {1, 2, 3},
                {2, 4, 6},
        };
        int[] kSet = new int[]{
                3,
                2,
                3,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = kSmallestPairsMy1(nums1Set[i], nums2Set[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("kSmallestPairs My1 result" + i + " ");
            for (List<Integer> list : result) {
                System.out.print("[");
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print("]; ");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = kSmallestPairsMy2(nums1Set[i], nums2Set[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("kSmallestPairs My2 result" + i + " ");
            for (List<Integer> list : result) {
                System.out.print("[");
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print("]; ");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < nums1Set.length; i++) {
            startTime = System.currentTimeMillis();
            result = kSmallestPairsAnswer1(nums1Set[i], nums2Set[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("kSmallestPairs Answer1 result" + i + " ");
            for (List<Integer> list : result) {
                System.out.print("[");
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print("]; ");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
