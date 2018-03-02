package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC715_RangeModule {
    /**
     * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
     * <p>
     * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
     * <p>
     * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
     * <p>
     * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
     * <p>
     * Example 1:
     * <p>
     * addRange(10, 20): null
     * removeRange(14, 16): null
     * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
     * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
     * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
     * <p>
     * Note:
     * A half open interval [left, right) denotes all real numbers left <= x < right.
     * 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
     * The total number of calls to addRange in a single test case is at most 1000.
     * The total number of calls to queryRange in a single test case is at most 5000.
     * The total number of calls to removeRange in a single test case is at most 1000.
     */

    public static class RangeModuleAnswer1 {
        private class Interval {
            int start, end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        TreeMap<Integer, Interval> intervals;

        public RangeModuleAnswer1() {
            intervals = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if (intervals.containsKey(left)) {
                Interval cur = intervals.get(left);
                cur.end = Math.max(cur.end, right);
                Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
                while (high != null) {
                    if (high.getKey() > cur.end) break;
                    intervals.remove(high.getKey());
                    cur.end = Math.max(cur.end, high.getValue().end);
                    high = intervals.higherEntry(cur.start);
                }
            } else {
                Interval cur = new Interval(left, right);
                Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
                if (low != null && low.getValue().end >= cur.start) {
                    intervals.remove(low.getKey());
                    cur.start = Math.min(cur.start, low.getValue().start);
                    cur.end = Math.max(cur.end, low.getValue().end);
                }
                Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
                while (high != null) {
                    if (high.getKey() > cur.end) break;
                    intervals.remove(high.getKey());
                    cur.end = Math.max(cur.end, high.getValue().end);
                    high = intervals.higherEntry(cur.start);
                }
                intervals.put(cur.start, cur);
            }
        }

        public boolean queryRange(int left, int right) {
            if (intervals.containsKey(left)) {
                Interval cur = intervals.get(left);
                return cur.end >= right;
            } else {
                Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
                return low != null && low.getValue().end >= right;
            }
        }

        public void removeRange(int left, int right) {
            if (intervals.containsKey(left)) {
                Interval cur = intervals.get(left);
                while (cur != null) {
                    if (cur.start >= right) break;
                    intervals.remove(cur.start);
                    if (right <= cur.end) {
                        cur.start = right;
                        intervals.put(cur.start, cur);
                        break;
                    } else {
                        Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
                        cur = high == null ? null : high.getValue();
                    }
                }
            } else {
                Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
                if (low != null) {
                    if (right < low.getValue().end) {
                        intervals.put(right, new Interval(right, low.getValue().end));
                    }
                    low.getValue().end = Math.min(low.getValue().end, left);
                }
                Map.Entry<Integer, Interval> high = intervals.higherEntry(left);
                Interval cur = high == null ? null : high.getValue();
                while (cur != null) {
                    if (cur.start >= right) break;
                    intervals.remove(cur.start);
                    if (right <= cur.end) {
                        cur.start = right;
                        intervals.put(cur.start, cur);
                        break;
                    } else {
                        high = intervals.higherEntry(cur.start);
                        cur = high == null ? null : high.getValue();
                    }
                }
            }
        }
    }

    public static class RangeModuleAnswer2 {
        // Combined a few logics together to make code look cleaner.
        // TreeMap<Integer, Integer>, key is the starting index and value is the ending index of the interval.
        // Maintainence is done to make sure no overlap intervals exist in the Map.
        TreeMap<Integer, Integer> map;

        public RangeModuleAnswer2() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if (right <= left) return;
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if (start == null && end == null) {
                map.put(left, right);
            } else if (start != null && map.get(start) >= left) {
                map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
            } else {
                map.put(left, Math.max(map.get(end), right));
            }
            // clean up intermediate intervals
            Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
            Set<Integer> set = new HashSet(subMap.keySet());
            map.keySet().removeAll(set);
        }

        public boolean queryRange(int left, int right) {
            Integer start = map.floorKey(left);
            if (start == null) return false;
            return map.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            if (right <= left) return;
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if (end != null && map.get(end) > right) {
                map.put(right, map.get(end));
            }
            if (start != null && map.get(start) > left) {
                map.put(start, left);
            }
            // clean up intermediate intervals
            Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
            Set<Integer> set = new HashSet(subMap.keySet());
            map.keySet().removeAll(set);
        }
    }

    /**
     * Your RangeModule object will be instantiated and called as such:
     * RangeModule obj = new RangeModule();
     * obj.addRange(left,right);
     * boolean param_2 = obj.queryRange(left,right);
     * obj.removeRange(left,right);
     */
}
