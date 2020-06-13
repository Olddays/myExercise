package com.liu.LeetCode.SeasonMatch20200418.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SM02_PassMessage {
    public static int numWays(int n, int[][] relation, int k) {
        if (n == 0 || relation.length == 0 || k == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> pathSet = new HashMap<>();
        for (int[] path : relation) {
            int start = path[0];
            int end = path[1];
            List<Integer> list;
            if (pathSet.containsKey(start)) {
                list = pathSet.get(start);
            } else {
                list = new ArrayList<>();
            }
            list.add(end);
            pathSet.put(start, list);
        }
        List<Integer> startTarget = pathSet.get(0);
        if (startTarget.size() == 0) {
            return 0;
        }
        List<Integer> finalSet = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            for (int next : startTarget) {
                if (pathSet.containsKey(next)) {
                    finalSet.addAll(pathSet.get(next));
                }
            }
            startTarget = finalSet;
            finalSet = new ArrayList<>();
        }
        int result = 0;
        for (int i : startTarget) {
            if (i == n - 1) {
                result++;
            }
        }
        return result;
    }
}
