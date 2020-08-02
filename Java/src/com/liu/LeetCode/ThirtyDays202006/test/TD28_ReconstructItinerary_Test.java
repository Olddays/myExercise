package com.liu.LeetCode.ThirtyDays202006.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD28_ReconstructItinerary.findItineraryAnswer1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD28_ReconstructItinerary.findItineraryMy1;

/**
 * Created by Liu on 2020/6/28.
 */
public class TD28_ReconstructItinerary_Test {
    public static void main(String[] args) {
        List<List<String>> tickets;
        List<String> cache;
        List<String> result;
        long startTime;
        long endTime;

        tickets = new ArrayList<>();
        cache = new ArrayList<>();
        cache.add("MUC");
        cache.add("LHR");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("JFK");
        cache.add("MUC");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("SFO");
        cache.add("SJC");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("LHR");
        cache.add("SFO");
        tickets.add(cache);
        startTime = System.currentTimeMillis();
        result = testMy1(tickets);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_ReconstructItinerary My 1 result " + result + " during time " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        result = testAnswer1(tickets);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_ReconstructItinerary Answer 1 result " + result + " during time " + (endTime - startTime));

        tickets = new ArrayList<>();
        cache = new ArrayList<>();
        cache.add("JFK");
        cache.add("SFO");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("JFK");
        cache.add("ATL");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("SFO");
        cache.add("ATL");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("ATL");
        cache.add("JFK");
        tickets.add(cache);
        cache = new ArrayList<>();
        cache.add("ATL");
        cache.add("SFO");
        tickets.add(cache);
        startTime = System.currentTimeMillis();
        result = testMy1(tickets);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_ReconstructItinerary My 1 result " + result + " during time " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        result = testAnswer1(tickets);
        endTime = System.currentTimeMillis();
        System.out.println("TD28_ReconstructItinerary Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static List<String> testMy1(List<List<String>> tickets) {
        return findItineraryMy1(tickets);
    }
    private static List<String> testAnswer1(List<List<String>> tickets) {
        return findItineraryAnswer1(tickets);
    }

}
