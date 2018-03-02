package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 2017/9/30.
 */
public class LC056_MergeIntervals {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * <p>
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     * <p>
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */

    public static class Interval {
        public int start;
        public int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    // 没有考虑lastInterval.end == interval.start的情况
    public static List<Interval> getMergeIntervalsMy1(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        result.add(intervals.get(0));
        for (int i = 1; i < length; i++) {
            int resultLength = result.size();
            Interval lastInterval = result.get(resultLength - 1);
            Interval interval = intervals.get(i);
            if (lastInterval.end > interval.start) {
                result.remove(resultLength - 1);
                result.add(new Interval(lastInterval.start, interval.end));
            } else {
                result.add(interval);
            }
        }
        return result;
    }

    // 没有考虑[1,4][0,4]这种前者比后者大的情况
    public static List<Interval> getMergeIntervalsMy2(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        result.add(intervals.get(0));
        for (int i = 1; i < length; i++) {
            int resultLength = result.size();
            Interval lastInterval = result.get(resultLength - 1);
            Interval interval = intervals.get(i);
            if (lastInterval.end >= interval.start) {
                result.remove(resultLength - 1);
                result.add(new Interval(lastInterval.start, interval.end));
            } else {
                result.add(interval);
            }
        }
        return result;
    }

    // 无法处理类似[0,3][5,8][2,6]这种先两端然后加入中间的问题
    public static List<Interval> getMergeIntervalsMy3(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        result.add(intervals.get(0));
        for (int i = 1; i < length; i++) {
            int resultLength = result.size();
            Interval interval = intervals.get(i);
            boolean hasMerge = false;
            for (int j = 0; j < resultLength; j++) {
                Interval resultInterval = result.get(j);
                if (resultInterval.end >= interval.start) {
                    result.remove(j);
                    int start = Math.min(resultInterval.start, interval.start);
                    int end = Math.max(resultInterval.end, interval.end);
                    result.add(j, new Interval(start, end));
                    hasMerge = true;
                }
            }
            if (!hasMerge) {
                result.add(interval);
            }
        }
        return result;
    }

    // 没有考虑到[1,4][0,0]这种输入
    public static List<Interval> getMergeIntervalsMy4(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            max = Math.max(max, interval.end);
        }
        boolean[] targetCache = new boolean[max + 1];
        for (Interval interval : intervals) {
            for (int i = interval.start; i < interval.end; i++) {
                targetCache[i] = true;
            }
        }
        int start = 0;
        boolean hasStart = false;
        for (int i = 0; i < max + 1; i++) {
            if (targetCache[i] && !hasStart) {
                hasStart = true;
                start = i;
            } else if (!targetCache[i] && hasStart) {
                hasStart = false;
                result.add(new Interval(start, i));
            }
        }
        return result;
    }

    // 没有处理[2,4][5,5]
    public static List<Interval> getMergeIntervalsMy5(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.end == 0 && interval.start == 0) {
                result.add(interval);
            }
            max = Math.max(max, interval.end);
        }
        boolean[] targetCache = new boolean[max + 1];
        for (Interval interval : intervals) {
            for (int i = interval.start; i < interval.end; i++) {
                targetCache[i] = true;
            }
        }
        int start = 0;
        boolean hasStart = false;
        for (int i = 0; i < max + 1; i++) {
            if (targetCache[i] && !hasStart) {
                hasStart = true;
                start = i;
            } else if (!targetCache[i] && hasStart) {
                hasStart = false;
                result.add(new Interval(start, i));
            }
        }
        return result;
    }

    // 尝试使用开一个大boolean数组,但是没有办法规避[1,2][3,4]这类问题,由于boolean数组会变为[false,true,true,true,true]
    public static List<Interval> getMergeIntervalsMy6(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            max = Math.max(max, interval.end);
        }
        boolean[] targetCache = new boolean[max + 2];
        for (Interval interval : intervals) {
            for (int i = interval.start; i <= interval.end; i++) {
                targetCache[i] = true;
            }
        }
        int start = 0;
        boolean hasStart = false;
        for (int i = 0; i < max + 2; i++) {
            if (targetCache[i] && !hasStart) {
                hasStart = true;
                start = i;
            } else if (!targetCache[i] && hasStart) {
                hasStart = false;
                result.add(new Interval(start, i - 1));
            }
        }
        return result;
    }

    public static List<Interval> getMergeIntervalsMy7(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            return result;
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

    public static List<Interval> getMergeIntervalsAnswer1(List<Interval> intervals) {
        // 这也是一种思路,可以拉出来两个数组,排序然后处理
        // 但是这个有一定问题对于[1,2],[3,5],[6,7],[8,10],[12,16]会错误
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> result = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                result.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return result;
    }
}
