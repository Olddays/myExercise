package com.liu.LeetCode.Daily.Daily202412;

import java.util.*;

public class LC2593_FindScoreOfAnArrayAfterMarkingAllElements {

    private static long findScoreMy1(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        PriorityQueue<Map.Entry<Integer, List<Integer>>> minHeap =
                new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            minHeap.add(entry);
        }
        long result = 0;
        while (!map.isEmpty() && !minHeap.isEmpty()) {
            Map.Entry<Integer, List<Integer>> entry = minHeap.peek();
            int key = entry.getKey();
            if (!map.containsKey(key)) {
                minHeap.poll();
                continue;
            }
            result += key;
            List<Integer> list = entry.getValue();
            int index = list.get(0);
            if (list.size() == 1) {
                map.remove(key);
                minHeap.poll();
            } else {
                list.remove(0);
            }
            int num;
            if (index + 1 < nums.length) {
                num = nums[index + 1];
                if (map.containsKey(num)) {
                    list = map.get(num);
                    if (list.size() == 1) {
                        map.remove(num);
                    } else {
                        list.remove(Integer.valueOf(index + 1));
                    }
                }
            }
            if (index - 1 >= 0) {
                num = nums[index - 1];
                if (map.containsKey(num)) {
                    list = map.get(num);
                    if (list.size() == 1) {
                        map.remove(num);
                    } else {
                        list.remove(Integer.valueOf(index - 1));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {730, 1721, 1993, 1532, 962, 519, 1365, 1307, 1992, 1623, 1579, 1735, 1015, 1579, 1003, 1277, 1255, 1254, 810, 1767, 206, 1837, 920, 1203, 1876, 521, 625, 483, 572, 922, 1936, 1014, 1835, 694, 19, 209, 1438, 127, 1716, 1272, 444, 1739, 148, 1580, 802, 1093, 1543, 452, 257, 103, 877, 749, 1418, 348, 1555, 1552, 818, 555, 1628, 547, 553, 1742, 1062, 1199, 1987, 818, 491, 1211},
                {2, 1, 3, 4, 5, 2},
                {2, 3, 5, 1, 3, 2},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findScoreMy1(numsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findScore My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
