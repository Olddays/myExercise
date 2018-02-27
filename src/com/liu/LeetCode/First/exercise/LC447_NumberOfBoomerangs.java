package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC447_NumberOfBoomerangs {
    /**
     * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
     * <p>
     * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
     * <p>
     * Example:
     * Input:
     * [[0,0],[1,0],[2,0]]
     * <p>
     * Output:
     * 2
     * <p>
     * Explanation:
     * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
     */

    // 不出所料的Time Limit Exceeded
    public static int getNumberOfBoomerangsMy1(int[][] points) {
        int length = points.length;
        int result = 0;
        if (length <= 2) {
            return result;
        }
        Map<Integer, List<int[]>> distanceCache = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getPointDistance(points[i], points[j]);
                List<int[]> list;
                if (distanceCache.containsKey(distance)) {
                    list = distanceCache.get(distance);
                } else {
                    list = new ArrayList<>();
                }
                list.add(new int[]{i, j});
                distanceCache.put(distance, list);
            }
        }
        for (Map.Entry<Integer, List<int[]>> entry : distanceCache.entrySet()) {
            List<int[]> list = entry.getValue();
            if (list.size() > 1) {
                Map<Integer, List<Integer>> resultCache = new HashMap<>();
                for (int[] point : list) {
                    List<Integer> cache;
                    if (resultCache.containsKey(point[0])) {
                        cache = resultCache.get(point[0]);
                    } else {
                        cache = new ArrayList<>();
                    }
                    cache.add(point[1]);
                    resultCache.put(point[0], cache);
                }
                for (Map.Entry<Integer, List<Integer>> entryCache : resultCache.entrySet()) {
                    int size = entryCache.getValue().size();
                    if (size > 1) {
                        int i = size * (size - 1);
                        result += i;
                    }
                }
            }
        }
        return result;
    }

    private static int getPointDistance(int[] A, int[] B) {
        return (int) (Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2));
    }

    public static int getNumberOfBoomerangsAnswer1(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getPointDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int val : map.values()) {
                result += val * (val - 1);
            }
            map.clear();
        }
        return result;
    }
}
