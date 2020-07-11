package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.*;

/**
 * Created by Liu on 2020/6/15.
 */
public class TD14_CheapestFlightsWithinKStops {
    // Time Limited
    public static int findCheapestPriceMy1(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> startMap = new HashMap<>();
        for (int[] flight : flights) {
            int start = flight[0];
            List<int[]> list = startMap.getOrDefault(start, new ArrayList<>());
            list.add(flight);
            startMap.put(start, list);
        }
        int lowestPrice = Integer.MAX_VALUE;
        if (startMap.containsKey(src)) {
            for (int[] flight : startMap.get(src)) {
                lowestPrice = Math.min(lowestPrice, depthFirstSearchMy1(startMap, flight, dst, 0, K));
            }
        }
        if (lowestPrice == Integer.MAX_VALUE) {
            return -1;
        }
        return lowestPrice;
    }

    private static int depthFirstSearchMy1(Map<Integer, List<int[]>> startMap, int[] flight, int targetID, int nowPrice, int step) {
        if (step < 0) {
            return Integer.MAX_VALUE;
        }
        int end = flight[1];
        int price = flight[2];
        if (end == targetID) {
            return nowPrice + price;
        }
        int lowestPrice = Integer.MAX_VALUE;
        if (startMap.containsKey(end)) {
            for (int[] nextFlight : startMap.get(end)) {
                lowestPrice = Math.min(lowestPrice, depthFirstSearchMy1(startMap, nextFlight, targetID, nowPrice + price, step - 1));
            }
        }
        return lowestPrice;
    }

    public static int findCheapestPriceAnswer1(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] flight : flights) {
            if (!prices.containsKey(flight[0])) {
                prices.put(flight[0], new HashMap<>());
            }
            prices.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> targetList = prices.getOrDefault(city, new HashMap<>());
                for (int nextStep : targetList.keySet()) {
                    pq.add(new int[]{price + targetList.get(nextStep), nextStep, stops - 1});
                }
            }
        }
        return -1;
    }
}
