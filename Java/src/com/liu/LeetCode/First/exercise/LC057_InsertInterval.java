package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC057_InsertInterval {
    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * <p>
     * You may assume that the intervals were initially sorted according to their start times.
     * <p>
     * Example 1:
     * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
     * <p>
     * Example 2:
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     * <p>
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */

    public static class Interval {
        public int start;
        public int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> getInsertIntervalMy1(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (null != newInterval) {
            // 先加入需要合并的数据
            intervals.add(newInterval);
        }
        int length = intervals.size();
        if (length <= 1) {
            return intervals;
        }
        // 先进行排序,这种lambda表达式只有Java8以上才能支持
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        result.add(intervals.get(0));
        for (int i = 1; i < length; i++) {
            int resultLength = result.size();
            Interval lastInterval = result.get(resultLength - 1);
            Interval interval = intervals.get(i);
            if (lastInterval.end >= interval.start) {
                result.remove(resultLength - 1);
                // 用于规避[1,4][2,3]
                int min = Math.min(lastInterval.start, interval.start);
                int max = Math.max(lastInterval.end, interval.end);
                result.add(new Interval(min, max));
            } else {
                result.add(interval);
            }
        }
        return result;
    }

    public static List<Interval> getInsertIntervalAnswer1(List<Interval> intervals, Interval newInterval) {
        // 也是一种很直白的方案
        List<Interval> result = new ArrayList<>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }
}
