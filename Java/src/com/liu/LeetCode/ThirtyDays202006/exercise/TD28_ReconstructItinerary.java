package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.*;

/**
 * Created by Liu on 2020/6/28.
 */
public class TD28_ReconstructItinerary {
    // 无法保证每个都只用一次
    public static List<String> findItineraryMy1(List<List<String>> tickets) {
        int length = tickets.size();
        Map<String, List<String>> travelMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            List<String> targets = travelMap.getOrDefault(start, new ArrayList<>());
            targets.add(ticket.get(1));
            travelMap.put(start, targets);
        }

        String now = "JFK"; // Default by problem
        List<String> result = new ArrayList<>();

        depthFirstSearchMy1(travelMap, length + 1, result, now);
        return result;
    }

    private static void depthFirstSearchMy1(Map<String, List<String>> travelMap, int length, List<String> result, String now) {
        if (result.size() < length) {
            result.add(now);
            if (travelMap.containsKey(now)) {
                List<String> nextList = travelMap.get(now);
                for (String next : nextList) {
                    depthFirstSearchMy1(travelMap, length, result, next);
                }
            }
        }
    }


    public static List<String> findItineraryAnswer1(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);
            flights.putIfAbsent(start, new PriorityQueue<>());
            flights.get(start).add(end);
        }
        depthFirstSearchAnswer1(flights, path, "JFK");
        return path;
    }

    public static void depthFirstSearchAnswer1(Map<String, PriorityQueue<String>> flights, LinkedList<String> path, String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            depthFirstSearchAnswer1(flights, path, arrivals.poll());
        }
        path.addFirst(departure);
    }
}
