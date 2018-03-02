package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC056_MergeIntervals.*;

import com.liu.LeetCode.First.exercise.LC056_MergeIntervals.Interval;

/**
 * Created by liu on 2017/9/14.
 */
public class LC056_MergeIntervalsTest {


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 3));
//        intervals.add(new Interval(2, 6));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(15, 18));
//        intervals.add(new Interval(18, 20));

//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(0, 4));

//        intervals.add(new Interval(0, 3));
//        intervals.add(new Interval(5, 8));
//        intervals.add(new Interval(2, 6));

//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(0, 0));

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 3));

//        intervals.add(new Interval(2, 3));
//        intervals.add(new Interval(5, 5));
//        intervals.add(new Interval(2, 2));
//        intervals.add(new Interval(3, 4));
//        intervals.add(new Interval(3, 4));

        List<Interval> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 1 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy2(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 2 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 2 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy3(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 3 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 3 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy4(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 4 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 4 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy5(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 5 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 5 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy6(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 6 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 6 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMy7(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals My 7 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals My 7 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(intervals);
        endTime = System.currentTimeMillis();
        System.out.println("MergeIntervals Answer 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("MergeIntervals Answer 1 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();
    }

    private static List<Interval> testMy1(List<Interval> intervals) {
        return getMergeIntervalsMy1(intervals);
    }

    private static List<Interval> testMy2(List<Interval> intervals) {
        return getMergeIntervalsMy2(intervals);
    }

    private static List<Interval> testMy3(List<Interval> intervals) {
        return getMergeIntervalsMy3(intervals);
    }

    private static List<Interval> testMy4(List<Interval> intervals) {
        return getMergeIntervalsMy4(intervals);
    }

    private static List<Interval> testMy5(List<Interval> intervals) {
        return getMergeIntervalsMy5(intervals);
    }

    private static List<Interval> testMy6(List<Interval> intervals) {
        return getMergeIntervalsMy6(intervals);
    }

    private static List<Interval> testMy7(List<Interval> intervals) {
        return getMergeIntervalsMy7(intervals);
    }

    private static List<Interval> testAnswer1(List<Interval> intervals) {
        return getMergeIntervalsAnswer1(intervals);
    }
}
