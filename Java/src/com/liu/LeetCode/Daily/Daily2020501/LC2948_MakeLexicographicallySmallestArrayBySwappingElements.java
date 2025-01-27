package com.liu.LeetCode.Daily.Daily2020501;

import java.util.*;

public class LC2948_MakeLexicographicallySmallestArrayBySwappingElements {

    // Beats 28.28%
    private static int[] lexicographicallySmallestArrayAnswer1(int[] nums, int limit) {
        int length = nums.length;
        // 使用带着index的数据组的值进行排序
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            pairs.add(new int[]{nums[i], i});
        }
        pairs.sort(Comparator.comparingInt(p -> p[0]));

        // 用不断增加最小值和limit进行分组，因为中间的数字可以作为切换时的中介
        // 核心是找到顺序的两个数值直接超过limit的时候，这个时候把数据给分成两部分分别重组
        List<List<int[]>> result = new ArrayList<>();
        result.add(new ArrayList<>(Collections.singletonList(pairs.get(0))));
        for (int i = 1; i < length; i++) {
            if (pairs.get(i)[0] - pairs.get(i - 1)[0] <= limit) {
                result.get(result.size() - 1).add(pairs.get(i));
            } else {
                result.add(new ArrayList<>(Collections.singletonList(pairs.get(i))));
            }
        }

        // 组内根据index重新排序
        for (List<int[]> group : result) {
            List<int[]> sortedGroup = new ArrayList<>(group);
            sortedGroup.sort(Comparator.comparingInt(p -> p[1]));
            for (int i = 0; i < group.size(); i++) {
                nums[sortedGroup.get(i)[1]] = group.get(i)[0];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {1, 5, 3, 9, 8},
                {1, 7, 6, 18, 2, 1},
                {1, 7, 28, 19, 10},
        };
        int[] limitSet = new int[]{
                2,
                3,
                3,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = lexicographicallySmallestArrayAnswer1(numsSet[i], limitSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("doesValidArrayExist My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
