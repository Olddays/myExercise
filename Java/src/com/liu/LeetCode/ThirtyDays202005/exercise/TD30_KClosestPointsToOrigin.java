package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.*;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD30_KClosestPointsToOrigin {
    public static int[][] kClosestMy1(int[][] points, int K) {
        int pointSize = points.length;
        if (pointSize <= K) {
            return points;
        }
        Map<Double, List<int[]>> map = new HashMap<>();
        for (int[] point : points) {
            double key = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            List<int[]> cache;
            if (map.containsKey(key)) {
                cache = map.get(key);
            } else {
                cache = new ArrayList<>();
            }
            cache.add(point);
            map.put(key, cache);
        }
        SortedSet<Double> keys = new TreeSet<>(map.keySet());
        int[][] result = new int[K][2];
        int i = 0;
        for (double key : keys) {
            for (int[] point : map.get(key)) {
                result[i] = point;
                i++;
                if (i >= K) {
                    return result;
                }
            }
        }
        return result;
    }
}
