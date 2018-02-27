package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC057_InsertInterval.*;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC057_InsertInterval.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC057_InsertIntervalTest {


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        Interval insertInterval = new Interval(4, 9);
        List<Interval> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(intervals, insertInterval);
        endTime = System.currentTimeMillis();
        System.out.println("InsertInterval My 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("InsertInterval My 1 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1(intervals, insertInterval);
        endTime = System.currentTimeMillis();
        System.out.println("InsertInterval Answer 1 result.size " + result.size() + " during time " + (endTime - startTime));
        for (Interval interval : result) {
            System.out.println("InsertInterval Answer 1 interval start " + interval.start
                    + " end " + interval.end + " during time " + (endTime - startTime));
        }
        System.out.println();
    }

    private static List<Interval> testMy1(List<Interval> intervals, Interval insertInterval) {
        return getInsertIntervalMy1(intervals, insertInterval);
    }

    private static List<Interval> testAnswer1(List<Interval> intervals, Interval insertInterval) {
        return getInsertIntervalAnswer1(intervals, insertInterval);
    }
}
