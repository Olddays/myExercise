package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD24_AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        goThrough(result, graph, graph.length, new ArrayList<>(), 0);
        return result;
    }

    private static void goThrough(List<List<Integer>> result, int[][] graph, int length, ArrayList<Integer> cache, int start) {
        if (start == length - 1) {
            cache.add(start);
            result.add(new ArrayList<>(cache));
        } else if (start < length - 1) {
            int[] nextList = graph[start];
            cache.add(start);
            for (int next : nextList) {
                goThrough(result, graph, length, cache, next);
                cache.remove(cache.size() - 1);
            }
        }
    }
}
